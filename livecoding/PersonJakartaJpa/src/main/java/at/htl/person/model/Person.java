package at.htl.person.model;

import javax.persistence.*;

@Entity
@Table(name = "MY_PERSON")
@NamedQuery(name="Person.findAll", query = "select p from Person p")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    public Person() {
    }

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%d: %s (%s)",id,name,city);
    }
}