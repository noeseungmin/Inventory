package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.domain.ItemType;
import com.project.inventory.dto.ItemDto;
import com.project.inventory.dto.ItemTypeDto;
import com.project.inventory.dto.ItemTypeDto.Request;
import com.project.inventory.dto.ItemTypeDto.Response;
import com.project.inventory.repository.ItemRepository;
import com.project.inventory.repository.ItemTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemTypeServiceImplTest {
    @InjectMocks
    ItemTypeServiceImpl itemTypeService;

    @Mock
    private ItemTypeRepository itemTypeRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void createdItem(){
        ItemType entity = ItemType.builder()
                .typeCode("C001")
                .name("가전제품")
                .build();

        Request request = Request.builder()
                .typeCode("C001")
                .name("가전제품")
                .build();

        when(itemTypeRepository.save(any(ItemType.class))).thenReturn(entity);

        Response actual = itemTypeService.create(request);

        assertThat(actual.getTypeCode()).isSameAs(entity.getTypeCode());

    System.out.println(actual.getName());
    System.out.println(actual.getTypeCode());

    }

}