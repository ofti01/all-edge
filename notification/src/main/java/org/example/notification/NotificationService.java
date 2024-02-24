package org.example.notification;



import lombok.AllArgsConstructor;
import org.lotfi.commons.payload.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toClientId(notificationRequest.clientID())
                        .toNameClient(notificationRequest.NameClient())
                        .sender("Lotfi")
                        .mesToCinClient(notificationRequest.cinClient())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
