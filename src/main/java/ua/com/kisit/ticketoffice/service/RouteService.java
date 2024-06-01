package ua.com.kisit.ticketoffice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.ticketoffice.entity.Routes;
import ua.com.kisit.ticketoffice.entity.Tickets;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.repository.RoutesRepository;
import ua.com.kisit.ticketoffice.repository.TicketsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RoutesRepository routesRepository;

    public List<Routes> findAllRoutes(){
        return routesRepository.findAll();
    }

    public void saveRoute(Routes routes){
        routesRepository.save(routes); // insert
    }

    public void updateRoute(Routes routes){
        routesRepository.save(routes); // update +id
    }

    public void  deleteRoute(Routes routes){
        routesRepository.delete(routes);
    }


    public void deleteAllRoutes(){
        routesRepository.deleteAll();
    }
}
