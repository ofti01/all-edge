package com.lotfi.compte.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
