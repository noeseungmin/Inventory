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
public class ItemType extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '종류 코드'")
    private String typeCode;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '종류 이름'")
    private String name;

}
