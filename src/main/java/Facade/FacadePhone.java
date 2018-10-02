package Facade;

import DTO.PhoneDTO;
import Entities.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadePhone {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public PhoneDTO getPhoneDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new PhoneDTO(em.find(Phone.class, id));
        } finally {
            em.close();
        }
    }

    public Phone getPhone(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Phone.class, id);
        } finally {
            em.close();
        }
    }
}
