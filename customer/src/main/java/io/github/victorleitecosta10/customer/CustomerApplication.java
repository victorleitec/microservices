package io.github.victorleitecosta10.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"io.github.victorleitecosta10.customer", "io.github.victorleitecosta10.amqp"})
@EnableFeignClients(basePackages = "io.github.victorleitecosta10.clients")
@PropertySource("classpath:clients-${spring.profiles.active}.properties")
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
