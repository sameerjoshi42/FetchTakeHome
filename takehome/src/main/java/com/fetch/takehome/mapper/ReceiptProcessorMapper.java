package com.fetch.takehome.mapper;

import com.fetch.takehome.model.Item;
import com.fetch.takehome.model.ItemRequest;
import com.fetch.takehome.model.Receipt;
import com.fetch.takehome.model.ReceiptRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReceiptProcessorMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Receipt convertToReceipt(ReceiptRequest request){
        Receipt receipt = this.modelMapper.map(request,Receipt.class);
        receipt.builder().total(Double.parseDouble(request.getTotal()))
                .items(this.convertToItem(request.getItems())).build();
        return receipt;
    }
    private List<Item> convertToItem(List<ItemRequest> itemRequestList){
        if(!itemRequestList.isEmpty()){
            List<Item> items = new ArrayList<>();
            System.out.println(itemRequestList.size());
            itemRequestList.forEach(itemRequest -> {
                items.add(Item.builder().shortDescription(itemRequest.getShortDescription())
                        .price(Double.parseDouble(itemRequest.getPrice())).build());
            });
            return items;
        }
        return new ArrayList<>();

    }
}
