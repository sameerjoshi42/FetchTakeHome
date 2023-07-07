package com.fetch.takehome.repository;

import com.fetch.takehome.model.Receipt;
import com.fetch.takehome.utils.ReceiptUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository{

    Map<String, Receipt> receiptMap = new HashMap<>();

    @Override
    public String processReceipt(Receipt receipt) {
        String receiptId = ReceiptUtils.generateId();
        receiptMap.put(receiptId, receipt);
        return receiptId;
    }

    @Override
    public Optional<Receipt> findReceiptById(String id) {
        // Check if isEmpty required
        if(!receiptMap.isEmpty()){
            if(receiptMap.containsKey(id)){
                return Optional.of(receiptMap.get(id));
            }
        }
        return Optional.empty();
    }
}
