package DTO;

import Entities.Address;
import Entities.Person;
import java.util.Collection;

public class AddressDTO {

    private String street;
    private String additionalInfo;
    private CityDTO cityDTO;
    private Collection<PersonDTO> persons;

    public AddressDTO(String street, String additionalInfo, CityDTO cityDTO) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.cityDTO = cityDTO;
    }

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.additionalInfo = address.getAdditionalinfo();
        this.cityDTO = new CityDTO(address.getCityinfo());
        convertPerson(address.getPersonCollection());
    }

    private void convertPerson(Collection<Person> persons) {
        for (Person person : persons) {
            this.persons.add(new PersonDTO(person));
        }
    }

    public AddressDTO() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

}
