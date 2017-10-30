package pan.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RegisterStudent {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterStudent.class);

    @GET
    @Path("/register-student")
    @Produces(MediaType.TEXT_PLAIN)
    public String registerStudent() {
        return "Student Successfully Registered";
    }
}