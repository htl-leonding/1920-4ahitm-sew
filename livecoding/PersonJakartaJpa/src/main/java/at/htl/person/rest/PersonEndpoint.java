package at.htl.person.rest;

import at.htl.person.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.lang.annotation.Repeatable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("person")
public class PersonEndpoint {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return em
                .createNamedQuery("Person.findAll", Person.class)
                .getResultList();
    }

    // tag::post[]
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional // <1>
    public Response create(Person person, @Context UriInfo uriInfo) { // <2>
        Person p = em.merge(person);
        Long id = p.getId();
        URI uri = uriInfo.getAbsolutePathBuilder().path("/" + id).build();
        return Response
                .created(uri)
                .header("greetings","hallo_du")
                .build();
    }
    // end::post[]
}
