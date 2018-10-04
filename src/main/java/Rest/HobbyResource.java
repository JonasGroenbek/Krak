package Rest;

import Facade.JSONConverter;
import Facade.FacadeHobby;
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

@Path("Hobby")
public class HobbyResource {

    FacadeHobby fHobby = new FacadeHobby();
    JSONConverter jsonConverter = new JSONConverter();

    @Context
    private UriInfo context;

    public HobbyResource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHobby(@PathParam("id") int id) {
        String JSONHobby = jsonConverter.getJsonFromHobby(fHobby.getHobby(id));
        return Response.ok(JSONHobby).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHobbies() {
        String JSONHobbies = jsonConverter.getJsonFromHobbies(fHobby.getHobbies());
        return Response.ok(JSONHobbies).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
