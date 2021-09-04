package br.com.gustavoakira.ms.order.adapters.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;

@Data
public class OrderDto {
    @NotNull
    private Map<UUID,Integer> products;
}
