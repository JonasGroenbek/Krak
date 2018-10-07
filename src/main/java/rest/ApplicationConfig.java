package rest;

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
        resources.add(exception.DataNotFoundExceptionMapper.class);
        resources.add(exception.GenericExceptionMapper.class);
        resources.add(filter.CorsFilter.class);
        resources.add(rest.AddressResource.class);
        resources.add(rest.CityinfoResource.class);
        resources.add(rest.HobbyResource.class);
        resources.add(rest.PersonResource.class);
        resources.add(rest.PhoneResource.class);
    }

}
