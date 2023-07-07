package com.fetch.takehome.repository;

import com.fetch.takehome.model.Receipt;

import java.util.Optional;

public interface ReceiptRepository {

    String processReceipt(Receipt receipt);

    Optional<Receipt> findReceiptById(String id);


}
