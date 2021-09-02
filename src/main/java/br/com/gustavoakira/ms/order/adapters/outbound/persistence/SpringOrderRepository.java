package br.com.gustavoakira.ms.order.adapters.outbound.persistence;

import br.com.gustavoakira.ms.order.adapters.outbound.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringOrderRepository extends JpaRepository<OrderEntity, UUID> {
}
