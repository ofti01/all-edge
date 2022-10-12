package com.lotfi.compte.repositories;

import com.lotfi.compte.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,String> {
    Compte getCompteByCinClient(String cin);
}
