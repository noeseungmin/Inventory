package com.project.inventory.dto;

import com.project.inventory.domain.Item;
import lombok.*;

public class WarehouseDto {

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
        private Item ItemId;
        private Integer quantity;
    }
}
