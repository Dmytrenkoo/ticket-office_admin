package ua.com.kisit.ticketoffice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.ticketoffice.entity.Tickets;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.service.TicketService;
import ua.com.kisit.ticketoffice.service.TrainService;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class AdminTicketController {

    private final TicketService ticketService;
    private final TrainService trainService;

    @GetMapping("/ticket-admin")
    public String getTicketManagerPage(Model model) {

        model.addAttribute("tickets", ticketService.findAllTickets());
        model.addAttribute("trains", trainService.findAllTrains());

        return "ticket-admin";
    }


    @PostMapping("/saveNewTicket")
    public String saveNewTicket(@RequestParam(name = "wagonNumber") Integer wagonNumber,
                                @RequestParam(name = "seatNumber") Integer seatNumber,
                                @RequestParam(name = "seatType") String seatType,
                                @RequestParam(name = "price") String price,
                                @RequestParam(name = "trains") Trains trains) {
        Tickets tickets = new Tickets();
        tickets.setWagonNumber(wagonNumber);
        tickets.setSeatNumber(seatNumber);
        tickets.setSeatType(seatType);
        tickets.setPrice(new BigDecimal(Double.parseDouble(price)));
        tickets.setTrains(trains);

        ticketService.saveTickets(tickets);

        return "redirect:/ticket-admin";
    }

    @PostMapping("/updateTicket")
    public String updateTicket(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "wagonNumber") Integer wagonNumber,
            @RequestParam(name = "seatNumber") Integer seatNumber,
            @RequestParam(name = "seatType") String seatType,
            @RequestParam(name = "price") String price,
            @RequestParam(name = "trains") Trains trains
    ) {
        Tickets tickets = new Tickets();
        tickets.setId(id);
        tickets.setWagonNumber(wagonNumber);
        tickets.setSeatNumber(seatNumber);
        tickets.setSeatType(seatType);
        tickets.setPrice(new BigDecimal(Double.parseDouble(price)));
        tickets.setTrains(trains);

        ticketService.updateTickets(tickets);

        return "redirect:/ticket-admin";
    }

    @PostMapping("/deleteTicket")
    public String updateTicket(
            @RequestParam(name = "id") Tickets tickets
    ) {
        ticketService.deleteTicket(tickets);

        return "redirect:/ticket-admin";
    }

    @PostMapping("/deleteAllTickets")
    public String deleteAllTicket(){

        ticketService.deleteAllTickets();

        return "redirect:/ticket-admin";
    }
}
