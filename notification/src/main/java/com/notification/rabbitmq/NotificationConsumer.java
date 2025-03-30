package com.notification.rabbitmq;

import com.clients.notification.NotificationRequest;
import com.notification.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(NotificationRequest request) {
        // Logic to handle the incoming message
        log.info("Consumed notification request: {}", request);
        notificationService.sedNotification(request);

    }
}
