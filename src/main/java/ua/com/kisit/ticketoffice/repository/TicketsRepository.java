package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Tickets;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
}
