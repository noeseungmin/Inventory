package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.dto.WarehouseDto;
import com.project.inventory.dto.WarehouseDto.Request;
import com.project.inventory.dto.WarehouseDto.Response;

import java.util.List;

public interface WarehouseService {
    Response create(Item itemId, Request request);

    List<Response> getAll();

    //List<Response> getSearch(Integer quantity, Request request);


}
