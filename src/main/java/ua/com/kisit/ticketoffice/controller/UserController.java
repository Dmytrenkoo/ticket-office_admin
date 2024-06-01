package ua.com.kisit.ticketoffice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.ticketoffice.bl.Cart;
import ua.com.kisit.ticketoffice.entity.Passengers;
import ua.com.kisit.ticketoffice.entity.Roles;
import ua.com.kisit.ticketoffice.entity.Users;
import ua.com.kisit.ticketoffice.repository.PassengersRepository;
import ua.com.kisit.ticketoffice.repository.UsersRepository;
import ua.com.kisit.ticketoffice.service.UserService;


import java.security.Principal;
import java.util.Collections;


@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final UsersRepository usersRepository;
    private final PassengersRepository passengersRepository;

    @GetMapping("/login")
    public String getPageLogin(){
        return "login";
    }


        @GetMapping("/registration")
    public String getPageRegistration(Model model){

        model.addAttribute("users", new Users());
        model.addAttribute("passengers", new Passengers());

        return "registration";
    }



    @PostMapping("/registration")
    public String saveNewUser(@Valid Users users,
                              BindingResult bindingResult1,
                              @Valid Passengers passengers,
                              BindingResult bindingResult2
    ){
        // Validation input user
        if(bindingResult1.hasErrors()){
            return "registration";
        }

        // Validation input client
        if(bindingResult2.hasErrors()){
            return "registration";
        }

        //  Перевірка на існування користувача в системі
        if(userService.getLogicUser(users.getUsername())) {
            return "registration";
        }


        users.setRolesset(Collections.singleton(new Roles(1L, "ROLE_User")));
        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));

        Users user1 =  usersRepository.save(users);



        passengers.setUser(user1);
        passengersRepository.save(passengers);
        // шифрування пароля
        return "redirect:/login";
    }


}




