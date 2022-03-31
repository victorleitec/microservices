package io.github.victorleitecosta10.clients.notification.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    private Integer toCustomerId;
    private String toCustomerName;
    private String message;
}
