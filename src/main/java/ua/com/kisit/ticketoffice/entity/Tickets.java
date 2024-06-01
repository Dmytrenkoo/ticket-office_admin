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
    @Column(name = "wagon_number")
    private Integer wagonNumber;
    @Column(name = "seat_number")
    private Integer seatNumber;
    @Column(name = "seat_type")
    private String seatType;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "trains_id")
    private Trains trains;

    @OneToMany(mappedBy = "_tickets")
    private List<TicketHasOrder> ticketHasOrders;

    public Tickets(Long id, Integer wagonNumber, Integer seatNumber, String seatType, BigDecimal price, Trains trains) {
        this.id = id;
        this.wagonNumber = wagonNumber;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.trains = trains;
    }
}
