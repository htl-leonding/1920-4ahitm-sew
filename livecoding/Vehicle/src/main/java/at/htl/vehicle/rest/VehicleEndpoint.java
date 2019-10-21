package at.htl.vehicle.rest;

import at.htl.vehicle.model.Vehicle;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("vehicle")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.TEXT_PLAIN,
        MediaType.APPLICATION_XML
})
public class VehicleEndpoint {

    @GET
    @Path("{id}")
    public Vehicle find(@PathParam("id") long id) {
        return new Vehicle("Opel " + id, "Commodore");
    }

    @GET
    public List<Vehicle> findAll() {
        List<Vehicle> all = new ArrayList<>();
        all.add(find(42));
        return all;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        System.out.println("deleted " + id);
    }

    @POST
    public void save(Vehicle vehicle) {
        System.out.println("Vehicle = " + vehicle);
    }

    //curl -X GET -H 'Accept: application/json' -i http://localhost:8080/vehicle/api/vehicle/
    //curl -X GET -H 'Accept: text/plain' -i http://localhost:8080/vehicle/api/vehicle/
}
