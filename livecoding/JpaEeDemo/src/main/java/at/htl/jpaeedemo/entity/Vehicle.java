package at.htl.jpaeedemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "VEH_VEHICLE")
@NamedQueries(
        @NamedQuery(
                name = "Vehicle.findall",
                query = "select v from Vehicle v"
        )
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s", id, brand, model);
    }
}
