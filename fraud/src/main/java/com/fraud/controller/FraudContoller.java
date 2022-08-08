package com.fraud.controller;

import com.fraud.dto.FraudCheckResponse;
import com.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud-check")
@AllArgsConstructor
public class FraudContoller {

    private final FraudCheckService fraudCheckService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Long customerId){

       boolean isFraudlentCustomer =
               fraudCheckService.isFraudlentCustomer(customerId);

       return new FraudCheckResponse(isFraudlentCustomer);
    }
}
