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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;
    private String payment;

    @ManyToOne
    @JoinColumn(name="passengers_id")
    private Passengers passengers;

    @OneToMany(mappedBy = "orders")
    private List<TicketHasOrder>  ticketHasOrders;
}
