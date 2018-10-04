package Facade;

import DTO.CityDTO;
import DTO.HobbyDTO;
import Entities.Cityinfo;
import Entities.Hobby;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadeHobby {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public HobbyDTO getHobbyDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Hobby.findById", Hobby.class);
            query.setParameter("id", id);
            Hobby hobby = (Hobby) query.getSingleResult();
            return new HobbyDTO(hobby);
        } finally {
            em.close();
        }
    }

    public Hobby getHobby(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Hobby.findById", Hobby.class);
            query.setParameter("id", id);
            Hobby hobby = (Hobby) query.getSingleResult();
            return hobby;

        } finally {
            em.close();
        }
    }

    public List<Hobby> getHobbies() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Hobby.findAll", Hobby.class);
            List<Hobby> hobbies = query.getResultList();
            return hobbies;

        } finally {
            em.close();
        }
    }
}
