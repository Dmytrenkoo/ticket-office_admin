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
@Table(name = "trains")
public class Trains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Integer seats;

    @OneToMany(mappedBy = "trains")
    private List<TrainHasTimetableHasRoute> trainHasTimetableHasRoutes;

    @OneToMany(mappedBy = "trains")
    private List<Tickets> tickets;
}
