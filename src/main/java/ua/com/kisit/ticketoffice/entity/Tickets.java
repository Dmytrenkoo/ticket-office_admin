package ua.com.kisit.ticketoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number_of_seats")
    private Integer numberOfSeats;
    @Column(name = "seat_type")
    private String seatType;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "trains_id")
    private Trains trains;

    @OneToMany(mappedBy = "tickets")
    private List<TicketHasOrder> ticketHasOrders;

}
