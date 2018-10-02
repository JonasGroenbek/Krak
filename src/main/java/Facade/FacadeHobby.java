package Facade;

import DTO.HobbyDTO;
import Entities.Hobby;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadeHobby {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public HobbyDTO getHobbyDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new HobbyDTO(em.find(Hobby.class, id));
        } finally {
            em.close();
        }
    }

    public Hobby getHobby(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Hobby.class, id);
        } finally {
            em.close();
        }
    }
}
