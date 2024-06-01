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
@Table(name = "ticket_has_order")
public class TicketHasOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tickets_id")
    private Tickets _tickets;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order _orders;

    private int quantity;

    public TicketHasOrder(Tickets _tickets, int quantity, Order _orders) {
        this._tickets = _tickets;
        this._orders = _orders;
        this.quantity = quantity;
    }
}
