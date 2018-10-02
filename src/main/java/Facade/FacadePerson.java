package Facade;

import DTO.PersonDTO;
import Entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadePerson {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public PersonDTO getPersonDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new PersonDTO(em.find(Person.class, id));
        } finally {
            em.close();
        }
    }

    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }
}
