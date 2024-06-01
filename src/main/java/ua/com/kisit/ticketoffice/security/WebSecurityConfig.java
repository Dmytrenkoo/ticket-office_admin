package ua.com.kisit.ticketoffice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.kisit.ticketoffice.TestAuthentication.TestAuthenticationSuccessHandler;
import ua.com.kisit.ticketoffice.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserService userService;
    private final TestAuthenticationSuccessHandler testAuthenticationSuccessHandler;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userService);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize)->
                        authorize
                                .requestMatchers("/","/timetable","/registration",
                                         "/order","/cart","/timetable/*","/addToCart","//timetable/{id}",
                                        "/updateItemInCart","/deleteItemFromCart","/deleteAllItem", "/static/**"
                                )
                                .permitAll()
                                .requestMatchers("/user","/order","/buy","/thanks")
                                .hasRole("User")
                                .requestMatchers("/admin", "/admin-users","/update-users","/update-roles-users", "/manager",
                                        "/timetable-admin","/saveNewTimetable", "/updateTimetable","/deleteTimetable","/deleteAllTimetables",
                                        "/ticket-admin", "/saveNewTicket", "/updateTicket", "/deleteTicket", "/deleteAllTickets",
                                        "/train-admin", "/saveNewTrain", "/updateTrain", "/deleteTrain", "/deleteAllTrains",
                                        "/routes-admin", "/saveNewRoute", "/updateRoute", "/deleteRoute", "/deleteAllRoutes",
                                        "/upload", "/profile"
                                )
                                .hasRole("Admin")
                                .anyRequest()
                                .authenticated()
                )
                .formLogin((form)-> form
                        .loginPage("/login")
                        .successHandler(testAuthenticationSuccessHandler)
                        .permitAll()

                )
                .logout((logout)->logout.permitAll().logoutSuccessUrl("/"))
                .authenticationProvider(authenticationProvider());

        return http.build();
    }

}
