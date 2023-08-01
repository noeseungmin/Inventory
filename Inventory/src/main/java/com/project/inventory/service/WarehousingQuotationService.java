package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.dto.WarehousingQuotationDto;
import com.project.inventory.dto.WarehousingQuotationDto.Request;
import com.project.inventory.dto.WarehousingQuotationDto.Response;

import java.util.List;

public interface WarehousingQuotationService {
    Response create(Item itemId, Request request);

    Response getQuotation(Long itemId);

    List<Response> getAll();
}
