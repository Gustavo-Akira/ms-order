package br.com.gustavoakira.ms.order.adapters.outbound.persistence.entity;

import br.com.gustavoakira.ms.order.application.domain.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private int quantity;

    private UUID productId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
