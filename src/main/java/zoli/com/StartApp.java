package zoli.com;

import configuration.MyAppConfiguration;
import healthcheck.FileZillaServerHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resources.SayHelloResource;

/**
 * Created by Zoli on 6/05/2017.
 */
public class StartApp extends Application<MyAppConfiguration> {


    public void run(MyAppConfiguration configuration, Environment e) throws Exception {

        //get config from yml file
        final String ftpserver = configuration.getFtpserver();
        final int ftpport = configuration.getFtpport();
        final String ftpuser = configuration.getFtpuser();
        final String ftppassword = configuration.getFtppassword();

        //add new resource
        e.jersey().register(new SayHelloResource(ftpserver,ftpport,ftpuser, ftppassword));

        //add healthchek
        final FileZillaServerHealthCheck healthCheck = new FileZillaServerHealthCheck(ftpserver, ftpport);
        e.healthChecks().register("filezillhealthcheck", healthCheck);
    }

    public static void main(String ... args) throws Exception {
        new StartApp().run(args);
    }
}
