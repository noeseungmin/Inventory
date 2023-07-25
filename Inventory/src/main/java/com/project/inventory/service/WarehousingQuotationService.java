package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.dto.WarehousingQuotationDto;
import com.project.inventory.dto.WarehousingQuotationDto.Request;
import com.project.inventory.dto.WarehousingQuotationDto.Response;

public interface WarehousingQuotationService {
    Response create(Item itemId, Request request);
}
