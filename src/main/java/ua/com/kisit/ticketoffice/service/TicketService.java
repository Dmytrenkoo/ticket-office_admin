package ua.com.kisit.ticketoffice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.ticketoffice.entity.Tickets;
import ua.com.kisit.ticketoffice.entity.TrainHasRoute;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.repository.TicketsRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketsRepository ticketsRepository;

    public List<Tickets> findAllTickets(){
        return ticketsRepository.findAll();
    }

    public List<Tickets> getTicketsByTrain(Trains trains){
        return ticketsRepository.findAllByTrains(trains);
    }

    public void saveTickets(Tickets tickets){
        ticketsRepository.save(tickets); // insert
    }

    public void updateTickets(Tickets tickets){
        ticketsRepository.save(tickets); // update +id
    }

    public void  deleteTicket(Tickets tickets){
        ticketsRepository.delete(tickets);
    }

    public Optional<Tickets> findTicketById(Long id){
        Optional<Tickets> tickets = ticketsRepository.findById(id);
        return tickets;
    }

    public void deleteAllTickets(){
        ticketsRepository.deleteAll();
    }

}
