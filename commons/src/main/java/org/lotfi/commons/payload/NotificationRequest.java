package org.lotfi.commons.payload;




public record NotificationRequest(
        Long clientID,
        String NameClient,
        String cinClient
) {
}
