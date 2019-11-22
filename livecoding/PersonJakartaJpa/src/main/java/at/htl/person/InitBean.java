package at.htl.person;

import at.htl.person.model.Hobby;
import at.htl.person.model.PerformsHobby;
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

        em.persist(new Hobby("Mountain-Biken"));
        em.persist(new Hobby("Lesen"));
        em.persist(new Hobby("BingenX"));
        em.persist(new Hobby("Ski fahren"));

        em.persist(new PerformsHobby(
                em.find(Hobby.class,1L),
                em.find(Person.class, 2L)
        ));
        em.persist(new PerformsHobby(
                em.find(Hobby.class,2L),
                em.find(Person.class, 2L)
        ));
        em.persist(new PerformsHobby(
                em.find(Hobby.class,1L),
                em.find(Person.class, 1L)
        ));

        Person chris = new Person("Chrisi", "Ansfelden");
        Hobby hobbyVomChrisi = new Hobby("Bingen");
        PerformsHobby pf = new PerformsHobby(hobbyVomChrisi, chris);
        chris = em.merge(chris);
        System.out.println(chris);
    }

}
