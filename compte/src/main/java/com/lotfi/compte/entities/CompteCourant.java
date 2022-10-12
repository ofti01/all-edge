package com.lotfi.compte.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
