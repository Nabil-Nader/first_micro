package com.clients.notification;

import com.clients.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {


    @PostMapping(path = "notification/")
    void sendNotification(@RequestBody NotificationRequest  notificationRequest);
}
