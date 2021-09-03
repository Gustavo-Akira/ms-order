package br.com.gustavoakira.ms.order.application.services;

import br.com.gustavoakira.ms.order.application.domain.Order;
import br.com.gustavoakira.ms.order.application.domain.Page;
import br.com.gustavoakira.ms.order.application.ports.OrderRepositoryPort;
import br.com.gustavoakira.ms.order.application.ports.OrderServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderServicePort {

    @Autowired
    private OrderRepositoryPort port;

    @Override
    public Order getOrder(UUID id) {
        return port.getOrder(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return port.saveOrder(order);
    }

    @Override
    public Order updateOrder(UUID id, Order order) {
        return port.updateOrder(id,order);
    }

    @Override
    public void removeOrder(UUID id) {
        port.removeOrder(id);
    }

    @Override
    public org.springframework.data.domain.Page<Order> getOrders(Page page) {
        return port.getOrders(page);
    }
}
