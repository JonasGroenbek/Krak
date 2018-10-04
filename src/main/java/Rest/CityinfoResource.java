package Rest;

import Facade.JSONConverter;
import Facade.FacadeCity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("City")
public class CityinfoResource {

    FacadeCity fCity = new FacadeCity();
    JSONConverter jsonConverter = new JSONConverter();

    @Context
    private UriInfo context;

    public CityinfoResource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityinfo(@PathParam("id") int id) {
        String JSONCityinfo = jsonConverter.getJsonFromCityinfo(fCity.getCityinfo(id));
        return Response.ok(JSONCityinfo).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityinfos() {
        String JSONCityinfos = jsonConverter.getJsonFromCityinfos(fCity.getAllCityinfos());
        return Response.ok(JSONCityinfos).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
