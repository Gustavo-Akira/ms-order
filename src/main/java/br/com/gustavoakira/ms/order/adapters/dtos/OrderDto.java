package br.com.gustavoakira.ms.order.adapters.dtos;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class OrderDto {
    @NotNull
    private UUID productId;

    @Max(10)
    @Min(1)
    private int quantity;
}
