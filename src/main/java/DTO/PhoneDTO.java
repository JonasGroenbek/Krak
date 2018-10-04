package DTO;

import Entities.Phone;

public class PhoneDTO {

    private String number;
    private String description;
    private PersonDTO person;

    public PhoneDTO(Phone phone) {
        this.number = phone.getNumber();
        this.description = phone.getDescription();
        this.person = new PersonDTO(phone.getPerson());
    }
}
