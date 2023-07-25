package com.project.inventory.service;

import com.project.inventory.domain.Item;
import com.project.inventory.dto.ItemDto.Request;
import com.project.inventory.dto.ItemDto.Response;
import com.project.inventory.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

//    @InjectMocks
//    ItemServiceImpl itemService;
//
//    @Mock
//    private ItemRepository itemRepository;
//
//    @Spy
//    private ModelMapper modelMapper;
//
//    @Test
//    void createdItem(){
//        Item entity = Item.builder()
//                .itemCode("A001")
//                .name("냉장고")
//                .typeId("전자제품")
//                .price(BigDecimal.valueOf(2000000))
//                .build();
//
//        Request request = Request.builder()
//                .itemCode("A001")
//                .name("냉장고")
//                .typeId("전자제품")
//                .price(BigDecimal.valueOf(2000000))
//                .build();
//
//        when(itemRepository.save(any(Item.class))).thenReturn(entity);
//
//        Response actual = itemService.create(typeId, request);
//
//        assertThat(actual.getItemCode()).isEqualTo(entity.getItemCode());
//        assertThat(actual.getName()).isEqualTo(entity.getName());
//
//    }
}