package com.fetch.takehome;

import com.fetch.takehome.model.Item;
import com.fetch.takehome.service.ReceiptServiceHelper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptProcessorHelperTest {

    @Autowired
    private ReceiptServiceHelper receiptServiceHelper;

    @Test
    public void calculateAlphaNumericTest(){
        String retailer = "Walmart";
        int expected_points = 7;
        int actual_points = receiptServiceHelper.calculatePointsForAlphanumericChar(retailer);
        Assertions.assertEquals(expected_points,actual_points);

    }
    @Test
    public void calculateRoundFigureAmountTest(){
        Double amount = 100.00;
        int expected_points = 50;
        int actual_points = receiptServiceHelper.calculatePointsForRoundFigureAmt(amount);
        Assertions.assertEquals(expected_points,actual_points);
    }
    @Test
    public void calculateRoundFigureAmountTest1(){
        Double amount = 100.48;
        int expected_points = 0;
        int actual_points = receiptServiceHelper.calculatePointsForRoundFigureAmt(amount);
        Assertions.assertEquals(expected_points,actual_points);
    }

    @Test
    public void calculatePointsForPointTwentyFiveMultiple(){
        Double amount = 100.00;
        int expected_points = 25;
        int actual_points = receiptServiceHelper.calculatePointsForPointTwentyFiveMultiple(amount);
        Assertions.assertEquals(expected_points,actual_points);
    }

    @Test
    public void calculatePointsForPointTwentyFiveMultiple1(){
        Double amount = 100.34;
        int expected_points = 0;
        int actual_points = receiptServiceHelper.calculatePointsForPointTwentyFiveMultiple(amount);
        Assertions.assertEquals(expected_points,actual_points);
    }

    @Test
    public void calculatePointsPerItemsSizeTest(){
        int size = 5;
        int expected_points = 10;
        int actual_points = receiptServiceHelper.calculatePointsPerItemsSize(size);
        Assertions.assertEquals(expected_points,actual_points);
    }

    @Test
    public void calculatePointsPerItemDescTest(){
        List<Item> itemList =  Arrays.asList(
                Item.builder()
                        .shortDescription("Pepsi")
                        .price(23.45).build(),
                Item.builder()
                        .shortDescription("Chicken")
                        .price(13.50).build(),
                Item.builder()
                        .shortDescription("Ramen")
                        .price(19.40).build());
        int actual_points = receiptServiceHelper.calculatePointsPerItemDesc(itemList);
        Assertions.assertEquals(0,actual_points);
    }
    @Test
    public void calculatePointsPerItemDescTest1(){
        List<Item> itemList =  Arrays.asList(
                Item.builder()
                        .shortDescription("Pepsi")
                        .price(23.45).build(),
                Item.builder()
                        .shortDescription("Chicken")
                        .price(13.50).build(),
                Item.builder()
                        .shortDescription("Tomato")
                        .price(19.40).build());
        int actual_points = receiptServiceHelper.calculatePointsPerItemDesc(itemList);
        Assertions.assertEquals(4,actual_points);
    }

    @Test
    public void calculatePointsForOddDate(){
        Date date = new Date(2023,07,05);
        int actual_points = receiptServiceHelper.calculatePointsForOddDate(date);
        Assertions.assertEquals(6,actual_points);
    }

    @Test
    public void calculatePointsForOddDate1(){
        Date date = new Date(2023,07,06);
        int actual_points = receiptServiceHelper.calculatePointsForOddDate(date);
        Assertions.assertEquals(0,actual_points);
    }

}
