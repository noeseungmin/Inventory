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

    @PostMapping("/{itemId}")
    public ResponseDto<Response> create(@PathVariable Item itemId, @RequestBody Request request){
        return ok(warehouseService.create(itemId, request));
    }

    @GetMapping
    public ResponseDto<List<Response>> getWarehouses(){
        return ok(warehouseService.getAll());
    }

    @PostMapping("/{itemId}/quotation")
    public ResponseDto<WarehousingQuotationDto.Response> createQuotation(@PathVariable Item itemId,
                                                                         @RequestBody WarehousingQuotationDto.Request request){
        return ok(warehousingQuotationService.create(itemId, request));

    }
}
