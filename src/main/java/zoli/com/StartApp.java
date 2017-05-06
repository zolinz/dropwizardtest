package zoli.com;

import configuration.MyAppConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resources.SayHelloResource;

/**
 * Created by Zoli on 6/05/2017.
 */
public class StartApp extends Application<MyAppConfiguration> {


    public void run(MyAppConfiguration configuration, Environment e) throws Exception {
        e.jersey().register(new SayHelloResource());
    }

    public static void main(String ... args) throws Exception {
        new StartApp().run(args);
    }
}
