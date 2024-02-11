package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Passengers;

public interface PassengersRepository extends JpaRepository<Passengers, Long> {
}
