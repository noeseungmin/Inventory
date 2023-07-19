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
public class BranchList extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '지점 코드'")
    private String blanchCode;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '이름'")
    private String name;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '주소'")
    private String address;

    @Column(columnDefinition = "varchar(20) DEFAULT NULL COMMENT '전화 번호'")
    private String tel;
}
