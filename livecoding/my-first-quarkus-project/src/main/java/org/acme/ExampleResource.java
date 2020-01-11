package org.acme;

import io.vertx.core.json.JsonObject;
import org.acme.model.Gift;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class ExampleResource {

    @Inject
    SantaClausService clausService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "helloxx";
    }

    @GET
    @Path("gift")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Gift> allGifts() {
        return clausService.findAllGifts();
    }

}