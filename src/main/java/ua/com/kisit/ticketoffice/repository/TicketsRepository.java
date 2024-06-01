package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Tickets;
import ua.com.kisit.ticketoffice.entity.Trains;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    List<Tickets> findAllByTrains(Trains trains);
}
