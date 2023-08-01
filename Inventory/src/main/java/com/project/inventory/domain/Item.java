package com.project.inventory.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
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

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '종류 코드'")
    private String typeCode;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '종류 이름'")
    private String typeName;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '상품 이름'")
    private String name;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '수량'")
    private Integer quantity;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '상품 가격'")
    private BigDecimal price;


}
