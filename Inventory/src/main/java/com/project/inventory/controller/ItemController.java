package com.project.inventory.controller;

import com.project.inventory.dto.ItemDto;
import com.project.inventory.dto.ItemDto.Request;
import com.project.inventory.dto.ItemDto.Response;
import com.project.inventory.dto.ItemDto.SearchRequest;
import com.project.inventory.dto.ItemTypeDto;
import com.project.inventory.dto.ResponseDto;
import com.project.inventory.service.ItemService;
import com.project.inventory.service.ItemTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController extends AbstractController{

    private final ItemService itemService;

    private final ItemTypeService itemTypeService;

    @PostMapping
    public ResponseDto<Response> create(@RequestBody Request request){
        return ok(itemService.create(request));
    }

    @GetMapping
    public ResponseDto<List<Response>> getAll(){
        return ok(itemService.getAll());
    }

    @GetMapping("/search")
    public ResponseDto<List<Response>> getSearch(@RequestParam String typeName){
        return ok(itemService.getSearch(typeName));
    }

    @GetMapping("/shortage")
    public ResponseDto<List<Response>> ShortageProducts(@RequestParam String typeName,
                                                        @RequestParam Integer quantity){
        return ok(itemService.ShortageProducts(typeName, quantity));
    }

    @PostMapping("/type")
    public ResponseDto<ItemTypeDto.Response> create(@RequestBody ItemTypeDto.Request request){
        return ok(itemTypeService.create(request));
    }
    @GetMapping("/type")
    public ResponseDto<List<ItemTypeDto.TypeResponse>> AllTypeGet(){
        return ok(itemTypeService.getAll());
    }
}
