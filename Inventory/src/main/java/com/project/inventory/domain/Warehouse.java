package com.project.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '상품 코드'")
    private String itemId;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '수량'")
    private Integer quantity;

}
