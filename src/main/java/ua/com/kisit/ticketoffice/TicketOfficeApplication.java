package ua.com.kisit.ticketoffice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.kisit.ticketoffice.entity.Roles;
import ua.com.kisit.ticketoffice.entity.Routes;
import ua.com.kisit.ticketoffice.entity.TrainHasRoute;
import ua.com.kisit.ticketoffice.entity.Trains;
import ua.com.kisit.ticketoffice.repository.RolesRepository;
import ua.com.kisit.ticketoffice.repository.RoutesRepository;
import ua.com.kisit.ticketoffice.repository.TrainHasRouteRepository;
import ua.com.kisit.ticketoffice.repository.TrainsRepository;

@RequiredArgsConstructor
@SpringBootApplication
public class TicketOfficeApplication {

    private final RolesRepository rolesRepository;
    private final TrainsRepository trainsRepository;
    private final RoutesRepository routesRepository;
    private final TrainHasRouteRepository trainHasRouteRepository;
    public static void main(String[] args) {
        SpringApplication.run(TicketOfficeApplication.class, args);
    }
    @Bean
    CommandLineRunner run() {

        return args -> {

            if (rolesRepository.findAll().isEmpty()) {
                rolesRepository.save(new Roles(1L, "ROLE_User"));
                rolesRepository.save(new Roles(2L, "ROLE_Admin"));
            }

            if (trainsRepository.findAll().isEmpty()) {
                trainsRepository.save(new Trains(1L, 1, "швидкісний", 100));

            }

        };
    }
}
