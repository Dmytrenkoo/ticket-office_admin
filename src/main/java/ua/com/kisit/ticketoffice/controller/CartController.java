package ua.com.kisit.ticketoffice.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.ticketoffice.bl.Cart;
import ua.com.kisit.ticketoffice.bl.ItemCart;
import ua.com.kisit.ticketoffice.entity.*;
import ua.com.kisit.ticketoffice.entity.Tickets;
import ua.com.kisit.ticketoffice.repository.TicketHasOrderRepository;
import ua.com.kisit.ticketoffice.service.OrderService;
import ua.com.kisit.ticketoffice.service.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final UserService userService;
    private final OrderService orderService;
    private final TicketHasOrderRepository ticketHasOrderRepository;


    @PostMapping("/addToCart")
    public String saveNewItemToCart(@RequestParam(name = "id") Tickets product,
                                    @RequestParam(name = "quantity") int quantity,
                                    HttpServletRequest request
    ) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model
    ) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());
        model.addAttribute("el", cart.getSumElInCart());

        return "cart";
    }


    @PostMapping("/updateItemInCart")
    public String updateItemInCart(@RequestParam(name = "id") Tickets tickets,
                                   @RequestParam(name = "quantity") int quantity,
                                   HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.updateItemInCart(tickets, quantity);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Tickets tickets,
                                     HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.deleteItemFromCart(tickets);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteAllItem")
    public String deleteAllItemFromCart(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.deleteAllItemFromCart();
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request,
                               Principal principal,
                               Model model) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());
        model.addAttribute("el", cart.getSumElInCart());


        Long userId = null;

        if (principal != null) {
            String username = principal.getName();
            userId = userService.getUserIdByUsername(username);
        }

        Passengers passengers = null;

        if (userId != null) {
            passengers = userService.getPassengerById(userId);
        }
        model.addAttribute("passengers", passengers);

        return "order";

    }


    @PostMapping("/buy")
    public String buyProduct(@RequestParam(name = "payment") String paymentId,
                             HttpServletRequest request
    ) {

        String payment = (paymentId.equals("1")) ? "Готівка" : "Банківська карта";

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            return "redirect:/timetable";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = (Users) userService.loadUserByUsername(auth.getName());
        Long passengerId = users.getId();


        if (passengerId != null) {

            Passengers passengers = userService.getPassengerById(passengerId);

            Order order = new Order();
            order.setPayment(payment);
            order.setPassengers(passengers);

            Order order1 = orderService.saveNewOrderForPassenger(order);

            for (ItemCart el : cart.getCart()) {
                ticketHasOrderRepository.save(new TicketHasOrder(el.getTickets(), el.getQuantity(), order1));
            }

            cart.getCart().clear();
            cart.setSumElInCart(0);
            cart.setTotalValue(0);

            session.setAttribute("cart", cart);

            return "redirect:/thank";
        } else {
            return "redirect:/category";
        }
    }

    @GetMapping("/thank")
    public String getPageThank() {
        return "thanks";
    }

}
