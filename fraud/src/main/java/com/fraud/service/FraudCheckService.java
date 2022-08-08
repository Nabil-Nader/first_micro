package com.fraud.service;


import com.fraud.model.FraudCheckHistory;
import com.fraud.repo.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;


    public boolean isFraudlentCustomer(Long customerId){

        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
