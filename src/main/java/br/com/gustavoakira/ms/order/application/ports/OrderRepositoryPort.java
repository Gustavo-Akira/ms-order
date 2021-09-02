package br.com.gustavoakira.ms.order.application.ports;

import br.com.gustavoakira.ms.order.application.domain.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepositoryPort {
    Order getOrder(UUID id);
    Order saveOrder(Order order);
    Order updateOrder(UUID id, Order order);
    void removeOrder(UUID id);
    List<Order> getOrders();
}
