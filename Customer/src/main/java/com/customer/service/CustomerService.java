package com.customer.service;

import com.customer.dto.CustomerRegistrationRequest;
import com.customer.model.Customer;
import com.customer.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository ;

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
        //save customer

        customerRepository.save(customer);
    }
}
