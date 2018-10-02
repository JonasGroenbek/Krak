package Rest;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Rest.AddressFacadeREST.class);
        resources.add(Rest.CityinfoFacadeREST.class);
        resources.add(Rest.HobbyFacadeREST.class);
        resources.add(Rest.PersonFacadeREST.class);
        resources.add(Rest.PhoneFacadeREST.class);
    }
    
}
