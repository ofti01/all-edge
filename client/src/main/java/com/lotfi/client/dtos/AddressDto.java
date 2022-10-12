package com.lotfi.client.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AddressDto implements Serializable {
    private final String street;
    private final String code;
    private final String region;
}
