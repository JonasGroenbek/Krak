package Rest;

import Facade.JSONConverter;
import Facade.FacadePerson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Person")
public class PersonResource {

    FacadePerson fPerson = new FacadePerson();
    JSONConverter jsonConverter = new JSONConverter();

    @Context
    private UriInfo context;

    public PersonResource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        String JSONPerson = jsonConverter.getJsonFromPerson(fPerson.getPerson(id));
        return Response.ok(JSONPerson).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {
        String JSONPersons = jsonConverter.getJsonFromPersons(fPerson.getAllPersons());
        return Response.ok(JSONPersons).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{email}/{firstName}/{lastName}/{addressId}")
    public Response postPerson(
            @PathParam("email") String email,
            @PathParam("firstName") String firstName,
            @PathParam("lastName") String lastName,
            @PathParam("addressId") int addressId){
        fPerson.postPersons(email, firstName, lastName, addressId);
        return Response.ok("Person created succesfully").build();
    }
}
