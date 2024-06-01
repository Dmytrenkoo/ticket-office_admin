package ua.com.kisit.ticketoffice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.ticketoffice.entity.Routes;
import ua.com.kisit.ticketoffice.entity.TrainHasRoute;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.repository.TrainHasRouteRepository;
import ua.com.kisit.ticketoffice.service.RouteService;
import ua.com.kisit.ticketoffice.service.TimetableService;
import ua.com.kisit.ticketoffice.service.TrainService;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminTimetableController {

    private final TimetableService timetableService;
    private final TrainService trainService;
    private final RouteService routeService;

    @GetMapping("/index-for-admin")
    public String getPageTimetableForAdmin(Model model) {

        model.addAttribute("trainHasRoutes", timetableService.findAllTimetables());
        return "index-for-admin";
    }

    @GetMapping("/timetable-admin")
    public String getTimetablePage(Model model){

        List<TrainHasRoute> trainHasRoutes = timetableService.findAllTimetables();
        model.addAttribute("trainHasRoutes", trainHasRoutes);
        model.addAttribute("trains", trainService.findAllTrains());
        model.addAttribute("routes", routeService.findAllRoutes());

        return "timetable-admin";
    }

    @PostMapping("/saveNewTimetable")
    public String saveNewTimetable(@RequestParam(name = "trains") Trains trains,
                                   @RequestParam(name = "arrivalDateTime") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") Date arrivalDateTime,
                                   @RequestParam(name = "departureTime") @DateTimeFormat(pattern = "HH:mm") LocalTime departureTime,
                                   //@RequestParam(name = "arrivalTime") @DateTimeFormat(pattern = "HH:mm") Time arrivalTime,
                                   @RequestParam(name = "route")Routes routes
    ){
        TrainHasRoute trainHasRoute = new TrainHasRoute();
        trainHasRoute.setTrains(trains);
        trainHasRoute.setArrivalDateTime(arrivalDateTime);
        // trainHasRoute.setArrivalTime(arrivalTime);
        trainHasRoute.setDepartureTime(departureTime);
        trainHasRoute.setRoutes(routes);

        timetableService.saveCategory(trainHasRoute);

        return "redirect:/timetable-admin";
    }

    @PostMapping("/updateTimetable")
    public String updateTimetable(@RequestParam(name = "id") Long id,
                                  @RequestParam(name = "trains") Trains trains,
                                  @RequestParam(name = "arrivalDateTime") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") Date arrivalDateTime,
                                  @RequestParam(name = "departureTime") @DateTimeFormat(pattern = "HH:mm") LocalTime departureTime,
                                  // @RequestParam(name = "arrivalTime") @DateTimeFormat(pattern = "HH:mm") Time arrivalTime,
                                  @RequestParam(name = "routes")Routes routes

    ){
        TrainHasRoute trainHasRoute = new TrainHasRoute();
        trainHasRoute.setId(id);
        trainHasRoute.setTrains(trains);
        trainHasRoute.setArrivalDateTime(arrivalDateTime);
        // trainHasRoute.setArrivalTime(arrivalTime);
        trainHasRoute.setDepartureTime(departureTime);
        trainHasRoute.setRoutes(routes);

        timetableService.updateTimetable(trainHasRoute);

        return "redirect:/timetable-admin";
    }


    @PostMapping("/deleteTimetable")
    public String deleteTimetable(@RequestParam(name = "id") TrainHasRoute trainHasRoute){

        timetableService.deleteTimetable(trainHasRoute);

        return "redirect:/timetable-admin";
    }

    @PostMapping("/deleteAllTimetables")
    public String deleteAllTimetable(){

        timetableService.deleteAllTimetable();

        return "redirect:/timetable-admin";
    }

}


