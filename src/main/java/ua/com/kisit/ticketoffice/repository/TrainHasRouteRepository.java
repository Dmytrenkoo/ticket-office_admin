package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.TimetableHasRoute;

public interface TimetableHasRouteRepository extends JpaRepository<TimetableHasRoute, Long> {
}
