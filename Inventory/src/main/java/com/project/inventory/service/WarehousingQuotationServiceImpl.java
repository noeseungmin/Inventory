package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.domain.WarehousingQuotation;
import com.project.inventory.dto.WarehousingQuotationDto.Request;
import com.project.inventory.dto.WarehousingQuotationDto.Response;
import com.project.inventory.repository.WarehousingQuotationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WarehousingQuotationServiceImpl implements WarehousingQuotationService{

    private final WarehousingQuotationRepository warehousingQuotationRepository;

    private final ModelMapper modelMapper;

    @Override
    public Response create(Item itemId, Request request) {
        WarehousingQuotation quotation = modelMapper.map(request, WarehousingQuotation.class);
        quotation.setItemId(itemId);
        BigDecimal totalPrice = BigDecimal.valueOf(quotation.getQuantity()).multiply(itemId.getPrice());
        quotation.setTotalPrice(totalPrice);
        WarehousingQuotation created = warehousingQuotationRepository.save(quotation);

        return modelMapper.map(created, Response.class);
    }
}
