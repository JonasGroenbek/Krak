package Facade;

import DTO.CityDTO;
import DTO.PersonDTO;
import Entities.Cityinfo;
import Entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadePerson {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public PersonDTO PersonDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Person.findById", Person.class);
            query.setParameter("id", id);
            Person person = (Person) query.getSingleResult();
            return new PersonDTO(person);
        } finally {
            em.close();
        }
    }

    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Person.findById", Person.class);
            query.setParameter("id", id);
            Person person = (Person) query.getSingleResult();
            return person;
        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Person.findAll", Person.class);
            List<Person> personList = query.getResultList();
            return personList;
        } finally {
            em.close();
        }
    }
}
