package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
