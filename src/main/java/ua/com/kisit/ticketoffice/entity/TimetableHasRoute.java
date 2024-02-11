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
@Table(name = "timetable_has_route")
public class TimetableHasRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "timetables_id")
    private Timetables timetables;

    @ManyToOne
    @JoinColumn(name = "routes_id")
    private Routes routes;

    @OneToMany(mappedBy = "timetableHasRoute")
    private List<TrainHasTimetableHasRoute> trainHasTimetableHasRoutes;

}
