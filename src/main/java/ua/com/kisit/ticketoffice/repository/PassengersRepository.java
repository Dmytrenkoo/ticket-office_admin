package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Passengers;
import ua.com.kisit.ticketoffice.entity.Users;

import java.util.List;

public interface PassengersRepository extends JpaRepository<Passengers, Long> {

}
