package Facade;

import java.util.HashMap;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {
        Persistence.generateSchema("krakpu", new HashMap<String, Object>());
    }
}
