package com.fetch.takehome.model;

import com.fetch.takehome.constants.ReceiptProcessorConstants;
import com.fetch.takehome.validation.DateValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptRequest {
//    @Pattern(regexp = ReceiptProcessorConstants.RETAIL_PATTERN,message = ReceiptProcessorConstants.RETAIL_PATTERN_MESSAGE)
    @NotEmpty(message = ReceiptProcessorConstants.RETAIL_NOT_EMPTY_MESSAGE)
    private String retailer;
    @NotEmpty(message = ReceiptProcessorConstants.PURCHASE_DATE_NOT_EMPTY_MESSAGE)
    @DateValidator
    private String purchaseDate;
    @NotEmpty(message = ReceiptProcessorConstants.PURCHASE_TIME_NOT_EMPTY_MESSAGE)
    @Pattern(regexp = ReceiptProcessorConstants.PURCHASE_TIME_PATTERN,message =
            ReceiptProcessorConstants.PURCHASE_TIME_PATTERN_MESSAGE)
    private String purchaseTime;
    @Size(min=1,message = ReceiptProcessorConstants.ITEM_LIST_NOT_EMPTY_MESSAGE)
    private List<@Valid ItemRequest> items;
    @Pattern(regexp = ReceiptProcessorConstants.TOTAL_AMOUNT_PATTERN,message =
            ReceiptProcessorConstants.TOTAL_AMOUNT_PATTERN_MESSAGE)
    @NotEmpty(message = ReceiptProcessorConstants.TOTAL_AMOUNT_NOT_EMPTY_MESSAGE)
    private String total;
}
