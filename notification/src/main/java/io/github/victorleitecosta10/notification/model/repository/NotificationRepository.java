package io.github.victorleitecosta10.notification.model.repository;

import io.github.victorleitecosta10.notification.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
