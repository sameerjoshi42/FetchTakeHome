package com.fetch.takehome.service;

import com.fetch.takehome.model.Receipt;
import com.fetch.takehome.model.ReceiptResponse;

public interface ReceiptService {

    String processReceipt(Receipt receipt);
    ReceiptResponse calculateRewardPoints(String id);
}
