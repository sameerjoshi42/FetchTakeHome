package com.fetch.takehome;
import com.fetch.takehome.controller.ReceiptController;
import com.fetch.takehome.mapper.ReceiptProcessorMapper;
import com.fetch.takehome.model.*;

import com.fetch.takehome.service.ReceiptService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Validator;
import java.util.Arrays;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptRequestProcessorControllerTest {

    @InjectMocks
    private ReceiptController receiptController;
    @Mock
    private ReceiptProcessorMapper mapper;

    @Mock
    private ReceiptService receiptService;

    private Validator validator;

    @Test
    public void receiptProcessSuccess(){
        when(mapper.convertToReceipt(this.getValidReceiptRequest())).thenReturn(this.getValidReceipt());
        when(receiptService.processReceipt(this.getValidReceipt())).thenReturn("6722b626-ffdf-42eb-a003-7e50d2f3bc74");
        ResponseEntity<String> response =  receiptController.processReceipt(this.getValidReceiptRequest());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());

    }
    @Test
    public void calculateRewardPointsSuccess(){

        when(receiptService.calculateRewardPoints("6722b626-ffdf-42eb-a003-7e50d2f3bc74"))
                .thenReturn(new ReceiptResponse());
        ResponseEntity<ReceiptResponse> response =  receiptController.calculateRewardPoints("6722b626-ffdf-42eb-a003-7e50d2f3bc74");
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    private ReceiptRequest getValidReceiptRequest(){
        return ReceiptRequest.builder().purchaseDate("2023-17-05")
                .purchaseTime("15:03")
                .retailer("Walmart")
                .total("56.35")
                .items(Arrays.asList(
                        ItemRequest.builder()
                                .shortDescription("Pepsi")
                                .price("23.45").build(),
                        ItemRequest.builder()
                                .shortDescription("Chicken")
                                .price("13.50").build(),
                        ItemRequest.builder()
                                .shortDescription("Ramen")
                                .price("19.40").build()
                )).build();
    }

    private Receipt getValidReceipt(){
        return Receipt.builder().purchaseDate("2023-07-05")
                .purchaseTime("15:03")
                .retailer("Walmart")
                .total(56.35)
                .items(Arrays.asList(
                        Item.builder()
                                .shortDescription("Pepsi")
                                .price(23.45).build(),
                        Item.builder()
                                .shortDescription("Chicken")
                                .price(13.50).build(),
                        Item.builder()
                                .shortDescription("Ramen")
                                .price(19.40).build()
                )).build();
    }

}
