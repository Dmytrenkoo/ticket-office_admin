package ua.com.kisit.ticketoffice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.service.TrainService;

@Controller
@RequiredArgsConstructor
public class AdminTrainController {

    private final TrainService trainService;

    @GetMapping("/train-admin")
    public String getTrainManagerPage(Model model) {

        model.addAttribute("trains", trainService.findAllTrains());

        return "train-admin";
    }


    @PostMapping("/saveNewTrain")
    public String saveNewTrain(@RequestParam(name = "trainNumber") Integer trainNumber,
                                @RequestParam(name = "seats") Integer seats,
                                @RequestParam(name = "type") String type
    ) {
        Trains trains = new Trains();
        trains.setTrainNumber(trainNumber);
        trains.setSeats(seats);
        trains.setType(type);

        trainService.saveTrain(trains);

        return "redirect:/train-admin";
    }

    @PostMapping("/updateTrain")
    public String updateTrain(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "trainNumber") Integer trainNumber,
            @RequestParam(name = "seats") Integer seats,
            @RequestParam(name = "type") String type
    ) {
        Trains trains = new Trains();
        trains.setId(id);
        trains.setTrainNumber(trainNumber);
        trains.setSeats(seats);
        trains.setType(type);

        trainService.updateTrain(trains);

        return "redirect:/train-admin";
    }

    @PostMapping("/deleteTrain")
    public String updateTrain(
            @RequestParam(name = "id") Trains trains
    ) {
        trainService.deleteTrain(trains);

        return "redirect:/train-admin";
    }

    @PostMapping("/deleteAllTrains")
    public String deleteAllTrains(){

        trainService.deleteAllTrains();

        return "redirect:/train-admin";
    }
}
