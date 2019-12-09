package at.htl.mock;


import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class LifecycleDemo {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @BeforeEach
    void before() {
        System.out.println("before each");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("after all");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("after each");
    }

    @Test
    void test10() {
        System.out.println("Test10");
    }

    @Test
    void test20() {
        System.out.println("Test20");
    }


}
