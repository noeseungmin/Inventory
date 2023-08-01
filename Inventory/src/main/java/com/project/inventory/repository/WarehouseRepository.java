package com.project.inventory.repository;

import com.project.inventory.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    List<Warehouse> findAll();

    List<Warehouse> findByQuantityContaining(Integer quantity);
}
