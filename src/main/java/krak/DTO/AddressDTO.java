package krak.dto;

import krak.entities.Address;

public class AddressDTO {

    private final String street;
    private final String additionalInfo;

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.additionalInfo = address.getAdditionalinfo();
    }
}
