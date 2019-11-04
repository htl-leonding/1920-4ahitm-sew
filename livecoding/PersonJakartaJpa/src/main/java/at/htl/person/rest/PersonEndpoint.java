package at.htl.person.rest;

import at.htl.person.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Person person) {
        System.out.println("---");
        Person p = em.merge(person);
        Response created = null;
        try {
            created = Response
                    .created(new URI("http://localhost:8080/person/api/person" + p.getId()))
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return created;
    }

}
