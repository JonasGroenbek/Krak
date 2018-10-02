package Rest;

import javax.persistence.EntityManager;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public Response create(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        return Response.ok().build();
    }

    public Response remove(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
        return Response.ok().build();
    }

    public Response find(int id) {
        return Response.ok(getEntityManager().find(entityClass, id)).build();
    }

    public Response findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return Response.ok(getEntityManager().createQuery(cq).getResultList()).build();
    }

    public Response count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return Response.ok(((Long) q.getSingleResult()).intValue()).build();
    }

}
