package at.htl.jpaeedemo.boundary;

import at.htl.jpaeedemo.entity.Vehicle;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/")
public class VehicleEndpoint {

    private int counter = 0;

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init() {
        System.err.println("VehicleEndpoint created *****");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle getOpel(@PathParam("id") long id) {
        return em.find(Vehicle.class,id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getAll() {
        return em
                .createNamedQuery("Vehicle.findall",Vehicle.class)
                .getResultList();
    }
}
