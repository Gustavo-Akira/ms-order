package br.com.gustavoakira.ms.order.adapters.outbound.persistence;

import br.com.gustavoakira.ms.order.adapters.outbound.persistence.entity.OrderEntity;
import br.com.gustavoakira.ms.order.application.domain.Order;
import br.com.gustavoakira.ms.order.application.domain.Page;
import br.com.gustavoakira.ms.order.application.ports.OrderRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PostgresOrderRepository implements OrderRepositoryPort {
    @Autowired
    private SpringOrderRepository orderRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Order getOrder(UUID id) {
        return mapper.map(orderRepository.findById(id).orElseThrow(),Order.class);
    }

    @Override
    public Order saveOrder(Order order) {
        return mapper.map(orderRepository.save(mapper.map(order, OrderEntity.class)),Order.class);
    }

    @Override
    public Order updateOrder(UUID id, Order order) {
        getOrder(id);
        order.setId(id);
        return mapper.map(orderRepository.save(mapper.map(order,OrderEntity.class)),Order.class) ;
    }

    @Override
    public void removeOrder(UUID id) {
        getOrder(id);
        orderRepository.deleteById(id);
    }

    @Override
    public org.springframework.data.domain.Page<Order> getOrders(Page page) {
        Pageable pageable = PageRequest.of(page.getPage(), page.getPageSize());
        return orderRepository.findAll(pageable).map(x->mapper.map(x,Order.class));
    }
}
