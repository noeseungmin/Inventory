package com.project.inventory.service;

import com.project.inventory.domain.ItemType;
import com.project.inventory.dto.ItemDto;
import com.project.inventory.dto.ItemTypeDto;
import com.project.inventory.dto.ItemTypeDto.Request;
import com.project.inventory.dto.ItemTypeDto.Response;
import com.project.inventory.dto.ItemTypeDto.TypeResponse;
import com.project.inventory.repository.ItemTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemTypeServiceImpl implements ItemTypeService{

    private final ItemTypeRepository itemTypeRepository;

    private final ModelMapper modelMapper;

    @Override
    public Response create(Request request) {

        ItemType itemType = modelMapper.map(request, ItemType.class);
        ItemType created = itemTypeRepository.save(itemType);

        return modelMapper.map(created, Response.class);
    }

    @Override
    public List<TypeResponse> getAll() {

        List<ItemType> itemTypes = itemTypeRepository.findAll();
        return itemTypes.stream().map(r -> modelMapper.map(r, TypeResponse.class)).collect(Collectors.toList());
    }
}
