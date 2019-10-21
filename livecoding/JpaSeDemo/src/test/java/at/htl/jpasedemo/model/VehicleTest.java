package at.htl.jpasedemo.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class VehicleTest {

    static EntityManager em;

    @BeforeAll
    private static void init() {
        em = Persistence
                .createEntityManagerFactory("myPU")
                .createEntityManager();

    }

    @Test
    void test01DatabaseConnection() {
        Vehicle opel = new Vehicle("Opel", "Kadett");
        em.getTransaction().begin();
        em.persist(opel);
        opel.setType("Commodore");
        em.getTransaction().commit();
    }

    @Test
    void test02readOneVehicle() {
        Vehicle opel = em.find(Vehicle.class,1L);
        assertThat(opel.getBrand(),is("Opel"));
        assertThat(opel.getType(),is("Kadett"));
    }

}