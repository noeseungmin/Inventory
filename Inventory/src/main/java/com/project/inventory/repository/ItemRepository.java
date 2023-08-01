package com.project.inventory.repository;

import com.project.inventory.domain.Item;
import com.project.inventory.dto.ItemDto.SearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    List<Item> findAll();

    List<Item> findByTypeNameContaining(String typeName);

    List<Item> findByTypeNameContainingAndQuantityLessThanEqual(String typeName, Integer quantity);
}
