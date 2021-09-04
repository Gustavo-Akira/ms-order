package br.com.gustavoakira.ms.order.application.domain;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class Order {
    private UUID id;
    private Map<UUID,Integer> products;
    private OrderStatus status = OrderStatus.NEW;
}
