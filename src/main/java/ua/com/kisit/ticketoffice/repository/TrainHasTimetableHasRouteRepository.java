package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.TrainHasTimetableHasRoute;

public interface TrainHasTimetableHasRouteRepository extends JpaRepository<TrainHasTimetableHasRoute, Long> {
}
