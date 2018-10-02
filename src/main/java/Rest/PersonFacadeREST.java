package Rest;

import Entities.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("person")
public class PersonFacadeREST extends AbstractFacade<Person> {

    @PersistenceContext(unitName = "krakpu")
    private EntityManager em;

    public PersonFacadeREST() {
        super(Person.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
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

    @GET
    @Path("{count}")
    public Response findAmount() {
        return super.count();
    }

}
