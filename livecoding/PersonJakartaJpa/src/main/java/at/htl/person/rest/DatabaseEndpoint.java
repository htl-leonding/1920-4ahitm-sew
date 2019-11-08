package at.htl.person.rest;

import at.htl.person.model.Hobby;
import at.htl.person.model.PerformsHobby;
import at.htl.person.model.Person;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Path("")
public class DatabaseEndpoint {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response showPErsonsOfHobbies() {

        PerformsHobby pf = em.find(PerformsHobby.class, 1L);
        return Response
                .ok(pf)
                .build();

    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPerfomHobbies() {

        List<PerformsHobby> pf = em
                .createNamedQuery("PerformsHobby.findAll", PerformsHobby.class)
                .getResultList();
        return Response
                .ok(pf.get(2).getPerson().getCity())
                .build();

    }

    @GET
    @Path("{name}")
    @Produces({
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_JSON
    })
    public Response getAllHobbiesForOnePerson(@PathParam("name") String name) {

        Person p = em
                .createNamedQuery("Person.findByName", Person.class)
                .setParameter("NAME", name)
                .getSingleResult();

        List<PerformsHobby> phlist = em
                .createNamedQuery("PerformsHobby.findByPersonId", PerformsHobby.class)
                .setParameter("ID", p.getId())
                .getResultList();
        List<Hobby> hobbies = new LinkedList<>();

        phlist.stream().forEach(ph -> {
            System.out.println(ph.getHobby().toString());
            hobbies.add(ph.getHobby());
        });


        return Response
                .ok(hobbies)
                .build();

    }
}
