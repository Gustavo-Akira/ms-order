package br.com.gustavoakira.ms.order.application.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Order {
    private UUID id;
    private int quantity;
    private UUID productId;
    private OrderStatus status = OrderStatus.NEW;
}
