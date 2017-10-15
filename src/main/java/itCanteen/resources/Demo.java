package itCanteen.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class Demo {

    @GET
    public String doGet() {
        return "Hello World!";
    }

}
