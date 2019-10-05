package at.htl.vehicle.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VehicleEndpointIT {
    private Client client;
    private WebTarget target;

    @BeforeEach
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/vehicle/api/vehicle");
    }

    @Test
    public void fetchVehicle() {
        Response response = this.target.request(MediaType.TEXT_PLAIN).get();
        assertThat(response.getStatus(), is(200));
        String payload = response.readEntity(String.class);
        System.out.println("payload = " + payload);
    }
}