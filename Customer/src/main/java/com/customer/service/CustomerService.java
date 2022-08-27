package com.customer.service;

import com.clients.fraud.FraudCheckResponse;
import com.clients.fraud.FraudClient;
import com.clients.notification.NotificationClient;
import com.clients.notification.NotificationRequest;
import com.customer.dto.CustomerRegistrationRequest;
import com.customer.model.Customer;
import com.customer.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse =fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, Welcome to Our server",customer.getFirstName())
                )
        );

    }
}