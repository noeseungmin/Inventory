package com.project.inventory.service;

import com.project.inventory.dto.ItemTypeDto.Request;
import com.project.inventory.dto.ItemTypeDto.Response;

public interface ItemTypeService {
    Response create(Request request);
}
