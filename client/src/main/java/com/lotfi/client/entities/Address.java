package com.lotfi.client.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String code;
    private String region;
}
