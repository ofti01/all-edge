package com.lotfi.compte.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class CompteCourantDto implements Serializable {
    private final String rib;
    private final String cinClient;
    private final double balance;
    private final double seuilRouge;
}
