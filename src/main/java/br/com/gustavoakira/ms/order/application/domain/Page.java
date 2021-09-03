package br.com.gustavoakira.ms.order.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Page {
    private Integer pageSize;
    private Integer page;
}
