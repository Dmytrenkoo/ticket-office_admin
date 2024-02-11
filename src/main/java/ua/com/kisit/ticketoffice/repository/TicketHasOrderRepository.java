package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.TicketHasOrder;

public interface TicketHasOrderRepository extends JpaRepository<TicketHasOrder, Long> {
}
