package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Zoli on 6/05/2017.
 */
public class MyAppConfiguration extends Configuration{
    //this class can read in external yaml config

    @NotEmpty
    private String ftpserver;

    @NotNull
    private int ftpport ;

    @NotEmpty
    private String ftpuser;

    @NotEmpty
    private String ftppassword;

    @JsonProperty
    public String getFtpserver() {
        return ftpserver;
    }

    @JsonProperty
    public void setFtpserver(String ftpserver) {
        this.ftpserver = ftpserver;
    }

    @JsonProperty
    public int getFtpport() {
        return ftpport;
    }

    @JsonProperty
    public void setFtpport(int ftpport) {
        this.ftpport = ftpport;
    }

    @JsonProperty
    public String getFtpuser() {
        return ftpuser;
    }

    @JsonProperty
    public void setFtpuser(String ftpuser) {
        this.ftpuser = ftpuser;
    }

    @JsonProperty
    public String getFtppassword() {
        return ftppassword;
    }

    @JsonProperty
    public void setFtppassword(String password) {
        this.ftppassword = password;
    }
}
