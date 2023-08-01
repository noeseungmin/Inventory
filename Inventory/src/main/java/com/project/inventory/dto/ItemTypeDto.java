package com.project.inventory.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemTypeDto {
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Request{
        private String typeCode;
        private String name;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response{

        private Long typeId;
        private String typeCode;
        private String name;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class TypeResponse{
        private String name;
    }
}
