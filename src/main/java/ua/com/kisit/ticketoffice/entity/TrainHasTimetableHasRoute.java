package ua.com.kisit.ticketoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "trainHasTimetableHasRoute")
public class TrainHasTimetableHasRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trains_id")
    private Trains trains;

    @ManyToOne
    @JoinColumn(name = "timetable_has_route_id")
    private TimetableHasRoute timetableHasRoute;

}
