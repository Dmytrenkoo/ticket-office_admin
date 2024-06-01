package ua.com.kisit.ticketoffice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.service.TicketService;


@Controller
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/timetable/{id}")
    public String getTicketsByTrains(@PathVariable(name = "id") Trains trains,
                                      Model model){
        model.addAttribute("ticketsByTrain", ticketService.getTicketsByTrain(trains));
        return "tickets-by-train";
    }

}
