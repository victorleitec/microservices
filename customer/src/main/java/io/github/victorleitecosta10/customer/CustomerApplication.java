package io.github.victorleitecosta10.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"io.github.victorleitecosta10.customer", "io.github.victorleitecosta10.amqp"})
@EnableEurekaClient
@EnableFeignClients(basePackages = "io.github.victorleitecosta10.clients")
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
