package resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.caching.CacheControl;
import views.SayHello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zoli on 6/05/2017.
 */
@Path("/sayhello")
@Produces(MediaType.APPLICATION_JSON)
public class SayHelloResource {

    @GET
    public SayHello sayHello() {
        return new SayHello("greetings" , "zolika");
    }
}
