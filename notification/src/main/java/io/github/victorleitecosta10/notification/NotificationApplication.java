package io.github.victorleitecosta10.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"io.github.victorleitecosta10.notification", "io.github.victorleitecosta10.amqp"})
@PropertySource("classpath:clients-${spring.profiles.active}.properties")
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
}