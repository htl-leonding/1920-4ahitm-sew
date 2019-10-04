package at.htl.restprimer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;

@Path("time")
public class TimeServerEndpoint {

    @GET
    public String time() {
        return "Time: " + LocalDateTime.now();
    }
}
