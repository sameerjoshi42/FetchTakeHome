package com.fetch.takehome.service;

import com.fetch.takehome.constants.ReceiptProcessorConstants;
import com.fetch.takehome.exception.ReceiptProcessorException;
import com.fetch.takehome.model.Receipt;
import com.fetch.takehome.model.ReceiptResponse;
import com.fetch.takehome.repository.ReceiptRepository;
import com.fetch.takehome.utils.ReceiptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ReceiptServiceHelper receiptServiceHelper;

    public String processReceipt(Receipt receipt){
        return receiptRepository.processReceipt(receipt);
    }

    @Override
    public ReceiptResponse calculateRewardPoints(String id) {

        Optional<Receipt> receiptOptional = receiptRepository.findReceiptById(id);
        if(receiptOptional.isPresent()){
            Receipt receipt = receiptOptional.get();

            Date dateTime = ReceiptUtils.convertStringToDate(receipt.getPurchaseDate(), receipt.getPurchaseTime());

            int points = receiptServiceHelper.calculatePointsForAlphanumericChar(receipt.getRetailer());
            points+=receiptServiceHelper.calculatePointsForRoundFigureAmt(receipt.getTotal());
            points+=receiptServiceHelper.calculatePointsForPointTwentyFiveMultiple(receipt.getTotal());
            points+=receiptServiceHelper.calculatePointsPerItemDesc(receipt.getItems());
            points+=receiptServiceHelper.calculatePointsForOddDate(dateTime);
            points+=receiptServiceHelper.calculatePointsPerItemsSize(receipt.getItems().size());
            points+=receiptServiceHelper.calculatePointsPerPurchaseTime(dateTime, receipt.getPurchaseDate());

            return new ReceiptResponse().builder().points(points).build();

        }
        else {
            throw new ReceiptProcessorException(ReceiptProcessorConstants.RECEIPT_NOT_FOUND_MESSAGE + id);
        }
    }
}
