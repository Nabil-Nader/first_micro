package com.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter@AllArgsConstructor
public class NotificationRequest {
    Long toCustomerId;
    String toCustomerEmail;
    String message;
}
