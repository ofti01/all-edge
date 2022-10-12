package com.lotfi.client.repositories;

import com.lotfi.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientByCin(String cin);
}
