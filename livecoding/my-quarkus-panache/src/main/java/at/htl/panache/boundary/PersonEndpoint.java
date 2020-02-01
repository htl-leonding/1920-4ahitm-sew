package at.htl.panache.boundary;

import at.htl.panache.control.PersonRepository;
import at.htl.panache.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("person")
@Transactional
public class PersonEndpoint {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return personRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Person person) {
        personRepository.persist(person);
        return Response.ok().build();
    }

}
