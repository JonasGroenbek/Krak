package dto;

import entities.Person;

public class PersonDTO {

    private String email;
    private String firstName;
    private String lastName;
    private final AddressDTO addressDTO;

    public PersonDTO(Person person) {
        this.email = person.getEmail();
        this.firstName = person.getFirstname();
        this.lastName = person.getLastname();
        this.addressDTO = new AddressDTO(person.getAddress());
    }
}
