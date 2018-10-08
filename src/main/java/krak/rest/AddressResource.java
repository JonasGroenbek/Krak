package krak.rest;

import krak.entities.Address;
import krak.facade.JSONConverter;
import krak.facade.FacadeAddress;
import java.util.List;
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
import static krak.rest.CorsUtil.*;

@Path("Address")
public class AddressResource {

    FacadeAddress fAddress = new FacadeAddress();
    JSONConverter jsonConverter = new JSONConverter();

    @Context
    private UriInfo context;

    public AddressResource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddresses(@PathParam("id") int id) {
        String JSONAddress = jsonConverter.getJSONfromAddress(fAddress.getAddress(id));
        return cors(Response.ok(JSONAddress)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddresses() {
        List<Address> addressList = fAddress.getAllAddresses();
        String JSONAddresses = jsonConverter.getJsonFromAddresses(addressList);
        return cors(Response.ok(JSONAddresses)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{info}/{street}/{cityId}")
    public Response postAddress(
            @PathParam("info") String info,
            @PathParam("street") String street,
            @PathParam("zip") int zip) {
        fAddress.postAddress(info, street, zip);
        return cors(Response.ok("Address created succesfully")).build();
    }
}
