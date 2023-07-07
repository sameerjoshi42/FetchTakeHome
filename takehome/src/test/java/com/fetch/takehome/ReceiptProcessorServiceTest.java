package com.fetch.takehome;

import com.fetch.takehome.exception.ReceiptProcessorException;
import com.fetch.takehome.repository.ReceiptRepository;
import com.fetch.takehome.service.ReceiptServiceHelper;
import com.fetch.takehome.service.ReceiptServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptProcessorServiceTest {

    @InjectMocks
    private ReceiptServiceImpl receiptService;
    @Mock
    private ReceiptRepository receiptRepository;
    @Mock
    private ReceiptServiceHelper receiptServiceHelper;

    @Test
    public void ReceiptNotFoundException() {
        when(receiptRepository.findReceiptById(any())).thenReturn(Optional.empty());
        ReceiptProcessorException exception =  Assertions.assertThrows(ReceiptProcessorException.class, () -> {
            receiptService.calculateRewardPoints(any());
    });


}
}