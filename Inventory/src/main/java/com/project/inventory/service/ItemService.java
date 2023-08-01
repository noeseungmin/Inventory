package com.project.inventory.service;

import com.project.inventory.dto.ItemDto;
import com.project.inventory.dto.ItemDto.Request;
import com.project.inventory.dto.ItemDto.Response;
import com.project.inventory.dto.ItemDto.SearchRequest;

import java.util.List;

public interface ItemService {

    Response create(Request request);

    List<Response> getAll();

    List<Response> getSearch(String typeName);

    List<Response> ShortageProducts(String typeName, Integer quantity);


}
