package ua.com.kisit.ticketoffice.bl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kisit.ticketoffice.entity.Tickets;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCart {
    private Tickets tickets;
    private int quantity;
}
