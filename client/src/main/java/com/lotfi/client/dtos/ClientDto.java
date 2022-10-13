package com.lotfi.client.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ClientDto implements Serializable {

    @JsonProperty(required = true)
    private  Long id;

    @JsonProperty(required = true)
    @NotNull
    @NotEmpty
    @NotBlank(message = "first name is mandatory")
    private  String firstName;

    @JsonProperty(required = true)
    @NotNull
    @NotEmpty
    @NotBlank(message = "last name is mandatory")
    private  String lastName;

    @JsonProperty(required = true)
    private  AddressDto addressDto;

    @JsonProperty(required = true)
    @NotNull
    @NotEmpty
    @NotBlank(message = "cin is mandatory")
    private  String cin;

    @JsonProperty(required = true)
    private  String statusClient;
}
