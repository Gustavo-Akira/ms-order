package br.com.gustavoakira.ms.order.adapters.inbound.controller;

import br.com.gustavoakira.ms.order.adapters.dtos.OrderDto;
import br.com.gustavoakira.ms.order.application.domain.Order;
import br.com.gustavoakira.ms.order.application.domain.Page;
import br.com.gustavoakira.ms.order.application.ports.OrderServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    private OrderServicePort port;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/orders/{page}")
    public ResponseEntity<org.springframework.data.domain.Page<Order>> getOrders(@PathVariable Integer page){
        return ResponseEntity.ok(port.getOrders(new Page(5,page)));
    }

    @GetMapping("/orders")
    public ResponseEntity<org.springframework.data.domain.Page<Order>> getOrders(){
        return ResponseEntity.ok(port.getOrders(new Page(5,0)));
    }


    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable UUID id){
        return ResponseEntity.ok(port.getOrder(id));
    }

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(port.saveOrder(mapper.map(orderDto,Order.class)));
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody OrderDto dto){
       return ResponseEntity.ok(port.updateOrder(id, mapper.map(dto,Order.class)));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> removeOrder(@PathVariable UUID id){
        port.removeOrder(id);
        return ResponseEntity.ok().build();
    }
}
