package com.project.inventory.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Builder
@Setter
@Getter
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

    @ManyToOne
    @JoinColumn(name ="item_id")
    private Item itemId;

    @Column(columnDefinition = "Integer DEFAULT NULL COMMENT '수량'")
    private Integer warehousingQuantity;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '총 금액'")
    private BigDecimal totalPrice;


}
