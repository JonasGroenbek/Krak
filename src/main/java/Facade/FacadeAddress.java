package Facade;

import DTO.AddressDTO;
import DTO.CityDTO;
import Entities.Address;
import Entities.Cityinfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadeAddress {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public AddressDTO getAddressDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Address.findById", Address.class);
            query.setParameter("id", id);
            Address address = (Address) query.getSingleResult();
            return new AddressDTO(address);
        } finally {
            em.close();
        }
    }

    public Address getAddress(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Address.findById", Address.class);
            query.setParameter("id", id);
            Address address = (Address) query.getSingleResult();
            return address;

        } finally {
            em.close();
        }
    }

    public List<Address> getAllAddresses() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Address.findAll", Address.class);
            List<Address> address = query.getResultList();
            return address;

        } finally {
            em.close();
        }
    }
}
