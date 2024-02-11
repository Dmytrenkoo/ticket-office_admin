package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
