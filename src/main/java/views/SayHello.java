package views;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Zoli on 6/05/2017.
 */
public class SayHello {

    private String message;

    private String name;


    public SayHello(String message, String name) {
        this.message = message;
        this.name = name;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

}
