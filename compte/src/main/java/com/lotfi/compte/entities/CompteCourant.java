package com.lotfi.compte.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CC")
@Builder
public class CompteCourant extends Compte {

    @Column(name = "seuil_rouge")
    private double seuilRouge;

}
