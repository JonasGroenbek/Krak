package DTO;

import Entities.Address;

public class AddressDTO {

    private final String street;
    private final String additionalInfo;
    private final CityDTO cityDTO;

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.additionalInfo = address.getAdditionalinfo();
        this.cityDTO = new CityDTO(address.getCityinfo());
    }
}
