package facade;

import dto.CityDTO;
import entities.Cityinfo;
import exception.DataNotFoundException;
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
            if(query == null){
                throw new DataNotFoundException("The data was not found");
            }
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

    public void postCity(String cityName, int zipcode) {
        Cityinfo city = new Cityinfo();
        city.setZip(zipcode);
        city.setCity(cityName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(city);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
