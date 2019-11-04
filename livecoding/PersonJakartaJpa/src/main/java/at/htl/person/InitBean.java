package at.htl.person;

import at.htl.person.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @PersistenceContext
    EntityManager em;

    @Transactional
    private void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

        em.persist(new Person("Susi", "Leonding"));
        em.persist(new Person("Hansi", "Linz"));
        em.persist(new Person("Mimi", "Leonding"));

    }

}
