package Rest;

import Facade.JSONConverter;
import Facade.FacadePhone;
import javax.json.Json;
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

@Path("Phone")
public class PhoneResource {
    
    FacadePhone fPhone = new FacadePhone();
    JSONConverter jsonConverter = new JSONConverter();
    
    @Context
    private UriInfo context;
    
    public PhoneResource() {
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPhone(@PathParam("id") int id) {
        String JSONPhone = jsonConverter.getJsonFromPhone(fPhone.getPhone(id));
        return Response.ok(JSONPhone).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPhones() {
        String JSONPhones = jsonConverter.getJsonFromPhones(fPhone.getPhones());
        return Response.ok(JSONPhones).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{description}/{number}/{personId}")
    public Response postPerson(
            @PathParam("description") String description,
            @PathParam("number") String number,
            @PathParam("personId") int personId) {
        fPhone.postPhone(description, number, personId);
        return Response.ok("Person created succesfully").build();
    }
}
