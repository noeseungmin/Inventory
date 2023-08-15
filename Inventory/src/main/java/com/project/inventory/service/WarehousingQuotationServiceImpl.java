package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.domain.WarehousingQuotation;
import com.project.inventory.dto.ItemDto;
import com.project.inventory.dto.WarehousingQuotationDto.Request;
import com.project.inventory.dto.WarehousingQuotationDto.Response;
import com.project.inventory.exception.BaseException;
import com.project.inventory.exception.ResultType;
import com.project.inventory.repository.ItemRepository;
import com.project.inventory.repository.WarehousingQuotationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehousingQuotationServiceImpl implements WarehousingQuotationService{

    private final WarehousingQuotationRepository warehousingQuotationRepository;

    private final ItemRepository itemRepository;

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @Override
    public Response create(Item itemId, Request request) {
        WarehousingQuotation quotation = modelMapper.map(request, WarehousingQuotation.class);
        quotation.setItemId(itemId);
        BigDecimal totalPrice = BigDecimal.valueOf(quotation.getWarehousingQuantity()).multiply(itemId.getPrice());
        quotation.setTotalPrice(totalPrice);
        WarehousingQuotation created = warehousingQuotationRepository.save(quotation);

        return modelMapper.map(created, Response.class);
    }

    @Override
    public Response getQuotation(Long itemId) {
        Optional<WarehousingQuotation> quotation = warehousingQuotationRepository.findById(itemId);

        return modelMapper.map(quotation, Response.class);
    }

    @Override
    public List<Response> getAll() {
        List<WarehousingQuotation> quotations = warehousingQuotationRepository.findAll();

        return quotations.stream().map(r -> modelMapper.map(r, Response.class)).collect(Collectors.toList());
    }

    @Override
    public Response quotationCreate(Long itemId, Request request) {

        if (!isWarehousingQuotationItem(itemId)){
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }
        WarehousingQuotation warehousingQuotation = modelMapper.map(request, WarehousingQuotation.class);

        ItemDto.Response updatedQuantity = itemService.quantityUpdate(itemId,
                ItemDto.WarehousingRequest.builder()
                        .warehousingQuantity(request.getWarehousingQuantity())
                        .build());

        Response response = modelMapper.map(warehousingQuotation, Response.class);
        response.setWarehousingQuantity(updatedQuantity.getQuantity());
        return response;
    }

    private boolean isWarehousingQuotationItem(Long itemId){
        Optional<Item> existItem = itemRepository.findById(itemId);
        if (existItem.isEmpty()){
            return false;
        }
        return existItem.isPresent();
    }
}
