package healthcheck;

import com.codahale.metrics.health.HealthCheck;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Zoli on 7/05/2017.
 */
public class FileZillaServerHealthCheck extends HealthCheck {

    private String server;

    private int port;



    public FileZillaServerHealthCheck(String server, int port){
        this.server = server;
        this.port = port;
    }

    protected Result check() throws Exception {
        try {
            Socket s = new Socket(server, port) ;
            return Result.healthy();
        } catch (IOException ex) {
        /* ignore */
        }
        return Result.unhealthy("Server unavailable");
    }
}
