package com.lotfi.compte.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CompteEpargneDto implements Serializable {
    private final String rib;
    private final String cinClient;
    private final double balance;
    private final double gain;
}
