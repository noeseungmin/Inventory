package com.project.inventory.dto;

import com.project.inventory.domain.Item;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

public class WarehousingQuotationDto implements Serializable {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Request{
        private Integer quantity;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response{
        private Long id;
        private String warehousingCode;
        private Item ItemId;
        private Integer quantity;
        private BigDecimal totalPrice;
    }
}
