package com.project.inventory.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemDto implements Serializable {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Request{
        private String itemCode;
        private String typeName;
        private String name;
        private Integer quantity;
        private BigDecimal price;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response{

        private Long ItemId;
        private String itemCode;
        private String typeCode;
        private String typeName;
        private String name;
        private BigDecimal price;
        private Integer quantity;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class SearchRequest{
        private String typeName;
        private Integer quantity;
    }

}
