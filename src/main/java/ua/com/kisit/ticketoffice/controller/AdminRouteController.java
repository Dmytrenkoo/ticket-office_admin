package ua.com.kisit.ticketoffice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.ticketoffice.entity.Routes;
import ua.com.kisit.ticketoffice.service.RouteService;

@Controller
@RequiredArgsConstructor
public class AdminRouteController {

    private final RouteService routeService;

    @GetMapping("/routes-admin")
    public String getRouteManagerPage(Model model) {

        model.addAttribute("routes", routeService.findAllRoutes());

        return "routes-admin";
    }


    @PostMapping("/saveNewRoute")
    public String saveNewRoute(@RequestParam(name = "departureStation") String departureStation,
                                @RequestParam(name = "arrivalStation") String arrivalStation,
                                @RequestParam(name = "travelTime") Double travelTime
    ) {
        Routes routes = new Routes();
        routes.setDepartureStation(departureStation);
        routes.setArrivalStation(arrivalStation);
        routes.setTravelTime(travelTime);

        routeService.saveRoute(routes);

        return "redirect:/routes-admin";
    }

    @PostMapping("/updateRoute")
    public String updateRoute(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "departureStation") String departureStation,
            @RequestParam(name = "arrivalStation") String arrivalStation,
            @RequestParam(name = "travelTime") Double travelTime
    ) {
        Routes routes = new Routes();
        routes.setId(id);
        routes.setDepartureStation(departureStation);
        routes.setArrivalStation(arrivalStation);
        routes.setTravelTime(travelTime);

        routeService.updateRoute(routes);

        return "redirect:/routes-admin";
    }

    @PostMapping("/deleteRoute")
    public String updateRoute(
            @RequestParam(name = "id") Routes routes
    ) {
        routeService.deleteRoute(routes);

        return "redirect:/routes-admin";
    }

    @PostMapping("/deleteAllRoutes")
    public String deleteAllRoutes(){

        routeService.deleteAllRoutes();

        return "redirect:/routes-admin";
    }
}
