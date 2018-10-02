package Facade;

import DTO.CityDTO;
import Entities.Cityinfo;
import Entities.Hobby;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadeCity {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public CityDTO getCityDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new CityDTO(em.find(Cityinfo.class, id));
        } finally {
            em.close();
        }
    }

    public Cityinfo getCity(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cityinfo.class, id);
        } finally {
            em.close();
        }
    }
}
