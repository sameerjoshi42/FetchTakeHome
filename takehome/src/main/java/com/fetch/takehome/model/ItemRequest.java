package com.fetch.takehome.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import com.fetch.takehome.constants.ReceiptProcessorConstants;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequest {

    @NotBlank(message = ReceiptProcessorConstants.SHORT_DESCRIPTION_NOT_EMPTY_MESSAGE)
    @Pattern(regexp = ReceiptProcessorConstants.SHORT_DESCRIPTION_PATTERN , message =
            ReceiptProcessorConstants.SHORT_DESCRIPTION_PATTERN_MESSAGE)
    private String shortDescription;

    @NotBlank(message = ReceiptProcessorConstants.ITEM_PRICE_NOT_EMPTY_MESSAGE)
    @Pattern(regexp = ReceiptProcessorConstants.ITEM_PRICE_PATTERN , message =
            ReceiptProcessorConstants.ITEM_PRICE_PATTERN_MESSAGE)
    private String price;
}
