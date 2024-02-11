package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.TimetableHasRoute;
import ua.com.kisit.ticketoffice.entity.Timetables;

public interface TimetablesRepository extends JpaRepository<Timetables, Long> {
}
