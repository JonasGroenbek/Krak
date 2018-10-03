package Facade;

import DTO.CityDTO;
import Entities.Cityinfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadeCity {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public CityDTO getCityDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Cityinfo.findById", Cityinfo.class);
            query.setParameter("id", id);
            Cityinfo cf = (Cityinfo) query.getSingleResult();
            return new CityDTO(cf);
        } finally {
            em.close();
        }
    }

    public Cityinfo getCityinfo(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Cityinfo.findById", Cityinfo.class);
            query.setParameter("id", id);
            Cityinfo cf = (Cityinfo) query.getSingleResult();
            return cf;

        } finally {
            em.close();
        }
    }

    public List<Cityinfo> getAllCityinfos() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Cityinfo.findAll", Cityinfo.class);
            List<Cityinfo> cityList = query.getResultList();
            return cityList;

        } finally {
            em.close();
        }
    }
}
