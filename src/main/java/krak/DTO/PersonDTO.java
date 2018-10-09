package krak.dto;

import krak.entities.Person;

public class PersonDTO {

    private String email;
    private String firstName;
    private String lastName;


    public PersonDTO(Person person) {
        this.email = person.getEmail();
        this.firstName = person.getFirstname();
        this.lastName = person.getLastname();
    }
}
