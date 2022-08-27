package com.ex.service;

import com.clients.notification.NotificationRequest;
import com.ex.model.Notification;
import com.ex.repo.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void addNotification(NotificationRequest request) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerEmail(request.getToCustomerEmail())
                        .toCustomerId(request.getToCustomerId())
                        .sender("BillyCode")
                        .message(request.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );

    }
}
