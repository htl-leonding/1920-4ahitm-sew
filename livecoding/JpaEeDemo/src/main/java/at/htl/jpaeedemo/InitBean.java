package at.htl.jpaeedemo;

import at.htl.jpaeedemo.entity.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InitBean {

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

        System.out.println("*** It works! ***");
        Vehicle opel = new Vehicle("Opel", "Kadett");
        em.persist(opel);
        em.persist(new Vehicle("Opel", "Kapitän"));
        em.persist(new Vehicle("Opel", "Commodore"));

    }

    public void tearDown(@Observes @Destroyed(ApplicationScoped.class) Object init) {
        // when app is undeployed
    }
}
