package ua.com.kisit.ticketoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "routes")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_station")
    private String departureStation;
    @Column(name = "arrival_station")
    private String arrivalStation;
    @Column(name = "travel_time")
    private Double travelTime;

    @OneToMany(mappedBy = "routes")
    private List<TrainHasRoute> trainHasRoutes;
}
