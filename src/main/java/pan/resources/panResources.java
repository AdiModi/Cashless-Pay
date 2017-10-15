package pan.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class panResources {

    @GET
    @Path("/panResources")
    @Produces(MediaType.APPLICATION_JSON)
    public String register() {
        return "Hello World";
    }
}
