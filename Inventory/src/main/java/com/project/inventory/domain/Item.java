package com.project.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '상품 코드'")
    private String itemCode;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '종류 ID'")
    private String typeId;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '상품 이름'")
    private String name;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '상품 가격'")
    private BigDecimal price;


}
