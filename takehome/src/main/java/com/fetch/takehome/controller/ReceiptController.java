package com.fetch.takehome.controller;

import com.fetch.takehome.constants.ReceiptProcessorConstants;
import com.fetch.takehome.mapper.ReceiptProcessorMapper;
import com.fetch.takehome.model.Receipt;
import com.fetch.takehome.model.ReceiptRequest;
import com.fetch.takehome.model.ReceiptResponse;
import com.fetch.takehome.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private ReceiptProcessorMapper receiptProcessorMapper;

    @PostMapping("/process")
    public ResponseEntity<String> processReceipt(@Valid @RequestBody ReceiptRequest receiptRequest){
        Receipt receipt = receiptProcessorMapper.convertToReceipt(receiptRequest);
        String receiptId = this.receiptService.processReceipt(receipt);
        return ResponseEntity.ok(receiptId);
    }
    @GetMapping("/{id}/points")
    public ResponseEntity<ReceiptResponse> calculateRewardPoints(
            @PathVariable(ReceiptProcessorConstants.ID) String id){
        ReceiptResponse points = receiptService.calculateRewardPoints(id);
        return ResponseEntity.ok(points);

    }
}

