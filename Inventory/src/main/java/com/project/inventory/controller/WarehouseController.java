package com.project.inventory.controller;

import com.project.inventory.domain.Item;
import com.project.inventory.dto.ResponseDto;
import com.project.inventory.dto.WarehouseDto;
import com.project.inventory.dto.WarehouseDto.Request;
import com.project.inventory.dto.WarehouseDto.Response;
import com.project.inventory.dto.WarehousingQuotationDto;
import com.project.inventory.service.WarehouseService;
import com.project.inventory.service.WarehousingQuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController extends AbstractController{
    private final WarehouseService warehouseService;

    private final WarehousingQuotationService warehousingQuotationService;

    @PostMapping("/{itemId}/warehouse")
    public ResponseDto<Response> create(@PathVariable Item itemId, @RequestBody Request request){
        return ok(warehouseService.create(itemId, request));
    }

    @GetMapping
    public ResponseDto<List<Response>> getWarehouses(){
        return ok(warehouseService.getAll());
    }
    @GetMapping("/quotation")
    public ResponseDto<List<WarehousingQuotationDto.Response>> getQuotation(){
        return ok(warehousingQuotationService.getAll());
    }

    @GetMapping("/{itemId}")
    public ResponseDto<WarehousingQuotationDto.Response> getQuotation(@PathVariable Long itemId){
        return ok(warehousingQuotationService.getQuotation(itemId));
    }

    @PostMapping("/{itemId}")
    public ResponseDto<WarehousingQuotationDto.Response> createQuotation(@PathVariable Item itemId,
                                                                         @RequestBody WarehousingQuotationDto.Request request){
        return ok(warehousingQuotationService.create(itemId, request));

    }

    @PostMapping("/{itemId}/update")
    public ResponseDto<WarehousingQuotationDto.Response> updatedQuotation(@PathVariable Long itemId,
                                                                          @RequestBody WarehousingQuotationDto.Request request){
        return ok(warehousingQuotationService.quotationCreate(itemId, request));
    }
}
