package io.github.victorleitecosta10.customer.service;

import io.github.victorleitecosta10.amqp.message.RabbitMQMessageProducer;
import io.github.victorleitecosta10.clients.fraud.client.FraudClient;
import io.github.victorleitecosta10.clients.fraud.request.FraudCheckResponse;
import io.github.victorleitecosta10.clients.notification.request.NotificationRequest;
import io.github.victorleitecosta10.customer.exception.EmailAlreadyTakenException;
import io.github.victorleitecosta10.customer.model.entity.Customer;
import io.github.victorleitecosta10.customer.model.repository.CustomerRepository;
import io.github.victorleitecosta10.customer.request.CustomerRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        Optional<Customer> customerFindByEmail = customerRepository.findByEmail(customer.getEmail());

        if (customerFindByEmail.isPresent() && customer.getEmail().equals(customerFindByEmail.get().getEmail())) {
            throw new EmailAlreadyTakenException("email already taken");
        }

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (Boolean.TRUE.equals(fraudCheckResponse.getFraudster())) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to my project", customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
