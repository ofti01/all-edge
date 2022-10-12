package com.lotfi.client.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class Address {
    private String street;
    private String code;
    private String region;
}
