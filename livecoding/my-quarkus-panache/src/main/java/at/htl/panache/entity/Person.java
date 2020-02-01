package at.htl.panache.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MY_PERSON")
public class Person extends PanacheEntity {

    @Column(name = "P_NAME")
    public String name;

    @Column(name = "P_DOB")
    public LocalDate birth;

    @Column(name ="P_STATUS")
    @Enumerated(EnumType.STRING)
    public Status status;

    public Person() {
    }

    public Person(String name, LocalDate birth, Status status) {
        this.name = name;
        this.birth = birth;
        this.status = status;
    }
}