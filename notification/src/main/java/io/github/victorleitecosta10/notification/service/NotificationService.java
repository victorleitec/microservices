package io.github.victorleitecosta10.notification.service;

import io.github.victorleitecosta10.notification.model.entity.Notification;
import io.github.victorleitecosta10.clients.notification.request.NotificationRequest;
import io.github.victorleitecosta10.notification.model.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerName())
                        .sender("Sender")
                        .message(notificationRequest.getMessage())
                        .sentAt(now())
                        .build()
        );
    }
}
