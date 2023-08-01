package com.project.inventory.service;

import com.project.inventory.dto.ItemTypeDto;
import com.project.inventory.dto.ItemTypeDto.Request;
import com.project.inventory.dto.ItemTypeDto.Response;
import com.project.inventory.dto.ItemTypeDto.TypeResponse;

import java.util.List;

public interface ItemTypeService {
    Response create(Request request);

    List<TypeResponse> getAll();
}
