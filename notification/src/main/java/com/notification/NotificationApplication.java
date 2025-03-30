package com.notification;

import com.learn_micro.config.RabbitMQMessageProducer;
import com.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages ={
        "com.notification",
        "com.learn_micro" // Include the amqp package for RabbitMQ configuration
})
@EnableEurekaClient
public class NotificationApplication {

    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(NotificationApplication.class, args);

    }


    @Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer,
            NotificationConfig notificationConfig
            ) {
        return args -> {
            producer.publish(
                   "Hello World from Notification Service",
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey());
        };
    }

   /*     @Bean
        CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer,
            NotificationConfig notificationConfig
            ) {
        return args -> {
            producer.publish(
                    new Person("Ali", 18),
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey());
        };
    }

    record Person(String name, int age){}

    */

}