package com.lotfi.client.services;

import com.lotfi.client.dtos.ClientDto;
import com.lotfi.client.entities.Client;
import com.lotfi.client.entities.StatusClient;

import com.lotfi.client.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.amqp.RabbitMQMessageProducer;
import org.lotfi.commons.payload.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public ClientDto saveClient(ClientDto clientDto){
        log.debug("save client ",clientDto);

        NotificationRequest notificationRequest= new NotificationRequest(
                clientDto.getId(),
                clientDto.getFirstName()+clientDto.getLastName(),
                clientDto.getCinClient()
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
        return toDto(clientRepository.save(fromDto(clientDto)));
    }

    public List<ClientDto> getAllClient(){
        log.debug("request to get all clients");
        return clientRepository.findAll().stream()
                .map(ClientService::toDto)
                .collect(Collectors.toList());
    }

    public static Client fromDto(ClientDto clientDto){
        return Client.builder()
                .id(clientDto.getId())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .cinClient(clientDto.getCinClient())
                .address(AddressService.fromDto(clientDto.getAddressDto()))
                .statusClient(Objects.equals(clientDto.getStatusClient(), "SINGLE") ? StatusClient.SINGLE: StatusClient.MARRIED)
                .build();
    }

    public static ClientDto toDto(Client client){
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .addressDto(AddressService.toDto(client.getAddress()))
                .cinClient(client.getCinClient())
                .statusClient(client.getStatusClient().toString())
                .build();
    }
}
