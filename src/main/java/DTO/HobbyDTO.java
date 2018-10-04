package DTO;

import Entities.Hobby;
import Entities.Person;
import java.util.Collection;

public class HobbyDTO {

    private String name;
    private String description;
    private Collection<PersonDTO> persons;

    public HobbyDTO(Hobby hobby) {
        this.name = hobby.getName();
        this.description = hobby.getDescription();
        convertPerson(hobby.getPersonCollection());
    }

    private void convertPerson(Collection<Person> persons) {
        for (Person person : persons) {
            this.persons.add(new PersonDTO(person));
        }
    }

    public HobbyDTO(String name, String description, Collection<PersonDTO> persons) {
        this.name = name;
        this.description = description;
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<PersonDTO> getPersons() {
        return persons;
    }

    public void setPersons(Collection<PersonDTO> persons) {
        this.persons = persons;
    }

}
