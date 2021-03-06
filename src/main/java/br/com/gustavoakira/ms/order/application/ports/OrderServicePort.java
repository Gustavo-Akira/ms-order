package br.com.gustavoakira.ms.order.application.ports;

import br.com.gustavoakira.ms.order.application.domain.Order;
import br.com.gustavoakira.ms.order.application.domain.Page;

import java.util.List;
import java.util.UUID;

public interface OrderServicePort {
    Order getOrder(UUID id);
    Order saveOrder(Order order);
    Order updateOrder(UUID id, Order order);
    void removeOrder(UUID id);
    org.springframework.data.domain.Page<Order> getOrders(Page page);
}
