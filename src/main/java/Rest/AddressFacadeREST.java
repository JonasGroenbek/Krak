package Rest;

import Entities.Address;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("address")
public class AddressFacadeREST extends AbstractFacade<Address> {

    public AddressFacadeREST() {
        super(Address.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("krakpu").createEntityManager();
    }

    @GET
    @Produces("application/json")
    @Override
    public Response findAll() {
        return super.findAll();
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    @Override
    public Response find(@PathParam("id") int id) {
        return super.find(id);
    }

}
