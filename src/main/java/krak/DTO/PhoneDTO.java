package krak.dto;

import krak.entities.Phone;

public class PhoneDTO {

    private String number;
    private String description;

    public PhoneDTO(Phone phone) {
        this.number = phone.getNumber();
        this.description = phone.getDescription();
    }
}
