package resources;

import filetransfer.FileZillaClient;
import filetransfer.MySftpClient;
import representation.SayHello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Zoli on 6/05/2017.
 */
@Path("/sayhello")
@Produces(MediaType.APPLICATION_JSON)
public class SayHelloResource {

    FileZillaClient fileZillaClient;

    MySftpClient sftpClient;

    public SayHelloResource(String server, int port, String user, String password){
        fileZillaClient = new FileZillaClient();
        fileZillaClient.setServer(server);
        fileZillaClient.setPort(port);
        fileZillaClient.setUser(user);
        fileZillaClient.setPassword(password);

        sftpClient = new MySftpClient();
    }

    @GET
    public SayHello sayHello() throws IOException{
       // return new SayHello("greetings" , fileZillaClient.getFileFromFTPServer());
        return new SayHello("greetings" , sftpClient.getFile());
    }
}
