package ua.com.kisit.ticketoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "train_has_route")
public class TrainHasRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "arrival_date_time")
    private Date arrivalDateTime;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @ManyToOne
    @JoinColumn(name = "trains_id")
    private Trains trains;

    @ManyToOne
    @JoinColumn(name = "routes_id")
    private Routes routes;
}
