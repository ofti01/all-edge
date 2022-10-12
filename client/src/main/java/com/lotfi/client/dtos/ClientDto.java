package com.lotfi.client.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
public class ClientDto implements Serializable {

    @JsonProperty(required = true)
    private final Long id;

    @JsonProperty(required = true)
    @NotNull
    @NotEmpty
    @NotBlank(message = "first name is mandatory")
    private final String firstName;

    @JsonProperty(required = true)
    @NotNull
    @NotEmpty
    @NotBlank(message = "last name is mandatory")
    private final String lastName;

    @JsonProperty(required = true)
    private final AddressDto addressDto;

    @JsonProperty(required = true)
    @NotNull
    @NotEmpty
    @NotBlank(message = "cin is mandatory")
    private final String cin;

    @JsonProperty(required = true)
    private final String statusClient;
}
