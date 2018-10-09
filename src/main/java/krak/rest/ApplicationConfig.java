package krak.rest;

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
        resources.add(krak.rest.AddressResource.class);
        resources.add(krak.rest.CityinfoResource.class);
        resources.add(krak.rest.DataNotFoundExceptionMapper.class);
        resources.add(krak.rest.GenericExceptionMapper.class);
        resources.add(krak.rest.HobbyResource.class);
        resources.add(krak.rest.PersonResource.class);
        resources.add(krak.rest.PhoneResource.class);
    }

}