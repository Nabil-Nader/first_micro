package com.customer.controller;

import com.customer.dto.CustomerRegistrationRequest;
import com.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customer){
        log.info( "register a new customer,{}",customer);
        customerService.registerNewCustomer(customer);

    }


}
