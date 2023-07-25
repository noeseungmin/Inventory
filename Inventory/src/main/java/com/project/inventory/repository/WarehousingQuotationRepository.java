package com.project.inventory.repository;

import com.project.inventory.domain.WarehousingQuotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousingQuotationRepository extends JpaRepository<WarehousingQuotation, Long> {
}
