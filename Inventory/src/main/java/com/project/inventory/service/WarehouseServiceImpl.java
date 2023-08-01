package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.domain.Warehouse;
import com.project.inventory.dto.WarehouseDto;
import com.project.inventory.dto.WarehouseDto.Request;
import com.project.inventory.dto.WarehouseDto.Response;
import com.project.inventory.repository.ItemRepository;
import com.project.inventory.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService{

    private final WarehouseRepository warehouseRepository;

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

    @Override
    public Response create(Item itemId, Request request) {
        Warehouse warehouse = modelMapper.map(request, Warehouse.class);

        warehouse.setItemId(itemId);
        Warehouse created = warehouseRepository.save(warehouse);
        return modelMapper.map(created, Response.class);
    }

    @Override
    public List<Response> getAll() {
        List<Warehouse> warehouses = warehouseRepository.findAll();

        return warehouses.stream().map(r -> modelMapper.map(r, Response.class)).collect(Collectors.toList());
    }

}
