package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.domain.ItemType;
import com.project.inventory.dto.ItemDto;
import com.project.inventory.dto.ItemDto.Request;
import com.project.inventory.dto.ItemDto.Response;
import com.project.inventory.exception.BaseException;
import com.project.inventory.exception.ResultType;
import com.project.inventory.repository.ItemRepository;
import com.project.inventory.repository.ItemTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    private final ItemTypeRepository itemTypeRepository;

    private final ModelMapper modelMapper;

    @Override
    public Response create(Request request) {
        Item item = modelMapper.map(request, Item.class);

        String typeName = item.getTypeName();
        ItemType byName = itemTypeRepository.findByName(typeName);
        item.setTypeCode(byName.getTypeCode());


        Item created = itemRepository.save(item);

        return modelMapper.map(created, Response.class);
    }

    @Override
    public List<Response> getAll() {
        List<Item> items = itemRepository.findAll();

        return items.stream().map(r -> modelMapper.map(r, Response.class)).collect(Collectors.toList());
    }


    @Override
    public List<Response> getSearch(String typeName) {
        List<Item> items = itemRepository.findByTypeNameContaining(typeName);

        return items.stream().map(r -> modelMapper.map(r, Response.class)).collect(Collectors.toList());
    }

    @Override
    public List<Response> ShortageProducts(String typeName, Integer quantity) {

        List<Item> items = itemRepository.findByTypeNameContainingAndQuantityLessThanEqual(typeName,quantity);

        return items.stream().map(r -> modelMapper.map(r, Response.class)).collect(Collectors.toList());
    }

    @Override
    public Response quantityUpdate(Long itemId, ItemDto.WarehousingRequest request) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        Integer updateQuantity = item.getQuantity();
        Integer warehousingQuantity = request.getWarehousingQuantity();
        updateQuantity = (updateQuantity + warehousingQuantity);
        item.setQuantity(updateQuantity);

        Item updated = itemRepository.save(item);
        return modelMapper.map(updated, Response.class);
    }
}
