package ua.com.kisit.ticketoffice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.repository.TrainsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainsRepository trainsRepository;

    public List<Trains> findAllTrains(){
        return trainsRepository.findAll();
    }

    public void saveTrain(Trains trains){
        trainsRepository.save(trains); // insert
    }

    public void updateTrain(Trains trains){
        trainsRepository.save(trains); // update +id
    }

    public void  deleteTrain(Trains trains){
        trainsRepository.delete(trains);
    }

    public Optional<Trains> findTrainsById(Long id){
        Optional<Trains> trains = trainsRepository.findById(id);
        return trains;
    }

    public void deleteAllTrains(){
        trainsRepository.deleteAll();
    }

}
