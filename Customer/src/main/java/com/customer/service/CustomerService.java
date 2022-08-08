package com.customer.service;

import com.customer.dto.CustomerRegistrationRequest;
import com.customer.dto.FraudCheckResponse;
import com.customer.model.Customer;
import com.customer.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository ;
    private final RestTemplate restTemplate;

    public void registerNewCustomer(CustomerRegistrationRequest request) {

        Customer customer =
                Customer
                .builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                .build();

        //check for email valid
        //check for email not taken

        //check for fraudster
        //save customer

        customerRepository.saveAndFlush(customer);

        //send notification




        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/fraud-check/{customerId}}",
                FraudCheckResponse.class,
                customer.getId()

        );

        if (fraudCheckResponse.isFraudster()){
            throw  new IllegalStateException("ops you are fraud!!!");
        }

    }
}
