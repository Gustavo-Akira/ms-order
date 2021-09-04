package br.com.gustavoakira.ms.order.adapters.outbound.persistence.entity;

import br.com.gustavoakira.ms.order.application.domain.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ElementCollection
    @MapKeyColumn(name= "products_map")
    @CollectionTable(name = "order_product_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    private Map<UUID, Integer> products;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
