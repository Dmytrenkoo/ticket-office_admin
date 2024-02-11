package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Trains;

public interface TrainsRepository extends JpaRepository<Trains, Long> {
}
