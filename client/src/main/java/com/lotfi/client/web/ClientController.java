package com.lotfi.client.web;

import com.lotfi.client.dtos.ClientDto;
import com.lotfi.client.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("client-service")
@RequiredArgsConstructor
public class ClientController {
    // todo method save and check unique in cin
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@Valid @RequestBody ClientDto clientDto){
        ClientDto dto = clientService.saveClient(clientDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll(){
        List<ClientDto> list = clientService.getAllClient();
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }
}
