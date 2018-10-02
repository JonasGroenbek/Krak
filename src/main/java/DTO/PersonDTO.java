package DTO;

import Entities.Hobby;
import Entities.Person;
import Entities.Phone;
import java.util.Collection;

public class PersonDTO {

    private String email;
    private String firstName;
    private String lastName;
    private Collection<PhoneDTO> phones;
    private Collection<HobbyDTO> hobbies;
    private AddressDTO address;

    public PersonDTO(String email, String firstName, String lastName, Collection<PhoneDTO> phones, Collection<HobbyDTO> hobbies, AddressDTO address) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
        this.hobbies = hobbies;
        this.address = address;
    }

    public PersonDTO(Person person) {
        this.email = person.getEmail();
        this.firstName = person.getFirstname();
        this.lastName = person.getLastname();
        this.address = new AddressDTO(person.getAddress());
        convertPhone(person.getPhoneCollection());
        convertHobby(person.getHobbyCollection());

    }

    private void convertHobby(Collection<Hobby> hobbies) {
        for (Hobby hobby : hobbies) {
            this.hobbies.add(new HobbyDTO(hobby));
        }
    }

    private void convertPhone(Collection<Phone> phones) {
        for (Phone phone : phones) {
            this.phones.add(new PhoneDTO(phone));
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(Collection<PhoneDTO> phones) {
        this.phones = phones;
    }

    public Collection<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Collection<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

}
