package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.TrainHasRoute;

public interface TrainHasRouteRepository extends JpaRepository<TrainHasRoute, Long> {
}
