package com.project.inventory.repository;

import com.project.inventory.domain.Item;
import com.project.inventory.domain.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {

    ItemType findByName(String name);
}
