package io.github.nfers.msdigitalbankperson.api.address.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDTO {
    private UUID id;
    private String street;
    private String number;
    private String complement;
    private Long city;
    private UUID state;
    private String postalCode;
    private String country;


}
