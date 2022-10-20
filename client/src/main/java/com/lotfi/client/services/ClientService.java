package com.lotfi.client.services;

import com.lotfi.client.dtos.ClientDto;
import com.lotfi.client.entities.Client;
import com.lotfi.client.entities.StatusClient;
import com.lotfi.client.exceptions.RessourceNotFound;
import com.lotfi.client.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientDto saveClient(ClientDto clientDto){
        log.debug("save client ",clientDto);
        return toDto(clientRepository.save(fromDto(clientDto)));
    }

    public List<ClientDto> getAllClient(){
        log.debug("request to get all clients");
        return clientRepository.findAll().stream()
                .map(ClientService::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto getOne(String cin){
        log.debug("request to get one client");
        Client client = clientRepository.getClientByCin(cin);
        if(client != null) return toDto(client);
        else return null;
    }

    public static Client fromDto(ClientDto clientDto){
        return Client.builder()
                .id(clientDto.getId())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .cin(clientDto.getCin())
                .address(AddressService.fromDto(clientDto.getAddressDto()))
                .statusClient(clientDto.getStatusClient() == "SINGLE" ? StatusClient.SINGLE: StatusClient.MARRIED)
                .build();
    }

    public static ClientDto toDto(Client client){
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .addressDto(AddressService.toDto(client.getAddress()))
                .cin(client.getCin())
                .statusClient(client.getStatusClient().toString())
                .build();
    }
}
