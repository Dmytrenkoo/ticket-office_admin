package ua.com.kisit.ticketoffice.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.ticketoffice.entity.Order;
import ua.com.kisit.ticketoffice.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveNewOrderForPassenger(Order order){
        return orderRepository.save(order);
    }

}
