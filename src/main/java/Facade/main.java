package Facade;

import DTO.CityDTO;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {

       // Map<String, String> persistenceProperties = new HashMap<>();
        Persistence.generateSchema("krakpu", null);

        FacadeCity fc = new FacadeCity();
        CityDTO citydto = fc.getCityDTO(100);
        System.out.println(fc.getCityDTO(1));
    }
}
