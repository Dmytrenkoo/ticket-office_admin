package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Routes;

public interface RoutesRepository extends JpaRepository<Routes, Long> {
}
