package ua.com.kisit.ticketoffice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.ticketoffice.entity.TrainHasRoute;
import ua.com.kisit.ticketoffice.repository.TrainHasRouteRepository;
import ua.com.kisit.ticketoffice.service.TimetableService;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;
    private final TrainHasRouteRepository trainHasRouteRepository;


    @GetMapping("/timetable")
    public String getPageTimetable(Model model) {

        model.addAttribute("trainHasRoutes", timetableService.findAllTimetables());
        return "timetable";
    }

    @GetMapping("/search")
    public String getPageSearch(@RequestParam(name = "arrivalStation", required = false) String arrivalStation,
                                @RequestParam(name = "arrivalTime1", required = false)  String arrivalTime1,
                                @RequestParam(name = "arrivalTime2", required = false)  String arrivalTime2,
                                @RequestParam(name = "arrivalDateTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date arrivalDateTime,
                                Model model) {
        List<TrainHasRoute> trainHasRoutes = trainHasRouteRepository.findAll();
        model.addAttribute("timetable", timetableService.searchRoutes(trainHasRoutes, arrivalStation, arrivalTime1, arrivalTime2, arrivalDateTime));
        return "search-result";
    }

}
