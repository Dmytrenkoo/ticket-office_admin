package ua.com.kisit.ticketoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.ticketoffice.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
