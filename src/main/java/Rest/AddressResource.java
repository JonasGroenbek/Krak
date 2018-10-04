package Rest;

import Facade.EntityToJSON;
import Facade.FacadeAddress;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Address")
public class AddressResource {

    FacadeAddress faddress = new FacadeAddress();
    EntityToJSON jsonConverter = new EntityToJSON();

    @Context
    private UriInfo context;

    public AddressResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddresses() {
        String JSONAddress = jsonConverter.getJsonFromAddresses(faddress.getAllAddresses());
        return Response.ok(JSONAddress).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
