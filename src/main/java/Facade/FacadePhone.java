package Facade;

import DTO.CityDTO;
import DTO.PhoneDTO;
import Entities.Cityinfo;
import Entities.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadePhone {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public PhoneDTO PhoneDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Phone.findById", Phone.class);
            query.setParameter("id", id);
            Phone phone = (Phone) query.getSingleResult();
            return new PhoneDTO(phone);
        } finally {
            em.close();
        }
    }

    public Phone getPhone(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Phone.findById", Phone.class);
            query.setParameter("id", id);
            Phone phone = (Phone) query.getSingleResult();
            return phone;

        } finally {
            em.close();
        }
    }

    public List<Phone> getPhones() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Phone.findAll", Phone.class);
            List<Phone> phoneList = query.getResultList();
            return phoneList;

        } finally {
            em.close();
        }
    }
}
