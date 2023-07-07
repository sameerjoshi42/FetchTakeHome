package com.fetch.takehome.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    private String retailer;

    private String purchaseDate;

    private String purchaseTime;

    private List<Item> items;

    private Double total;
}
