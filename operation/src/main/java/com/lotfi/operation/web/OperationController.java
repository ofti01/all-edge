package com.lotfi.operation.web;

import com.lotfi.operation.entities.Operation;
import com.lotfi.operation.repositories.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/operation-service")
@RequiredArgsConstructor
public class OperationController {


    private final OperationRepository operationRepository;

    @GetMapping
    public List<Operation> getAllOperation() {
        return operationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Operation getOperation(@PathVariable String id) {
        return operationRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot Find Operation By ID: " + id));
    }

    @PostMapping
    public ResponseEntity<String> saveOperation(@RequestBody Operation product) {
        Operation saveOperation = operationRepository.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveOperation.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
