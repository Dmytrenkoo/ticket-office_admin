package ua.com.kisit.ticketoffice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/")
    public String getPageHome(Model model){
        return "index-user";
    }

    @GetMapping("/manager")
    public String getManagerPage(){
        return "manager";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

}
