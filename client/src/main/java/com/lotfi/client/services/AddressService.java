package com.lotfi.client.services;

import com.lotfi.client.dtos.AddressDto;
import com.lotfi.client.entities.Address;

public class AddressService {

     public static Address fromDto(AddressDto addressDto){
         if(addressDto == null) return null;
         return Address.builder()
                 .street(addressDto.getStreet())
                 .code(addressDto.getCode())
                 .region(addressDto.getRegion())
                 .build();
     }

     public static AddressDto toDto(Address address){
         if(address == null) return null;
         return AddressDto.builder()
                 .street(address.getStreet())
                 .code(address.getCode())
                 .region(address.getRegion())
                 .build();
     }
}
