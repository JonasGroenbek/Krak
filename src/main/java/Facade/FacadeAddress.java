package Facade;

import DTO.AddressDTO;
import Entities.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadeAddress {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("krakpu");

    public AddressDTO getAddressDTO(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new AddressDTO(em.find(Address.class, id));
        } finally {
            em.close();
        }
    }

    public Address getAddress(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Address.class, id);
        } finally {
            em.close();
        }
    }
}
