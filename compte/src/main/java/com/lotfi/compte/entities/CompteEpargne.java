package com.lotfi.compte.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;



@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("CE")
@Builder
public class CompteEpargne extends Compte{

    @Column(name = "gain")
    private double gain;
}
