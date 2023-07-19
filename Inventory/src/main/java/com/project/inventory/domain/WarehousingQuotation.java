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
public class WarehousingQuotation extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '입고 코드'")
    private String warehousingCode;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '상품 ID'")
    private String itemId;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '수량'")
    private Integer quantity;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '총 금액'")
    private BigDecimal price;


}
