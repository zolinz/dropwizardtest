package filetransfer;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by Zoli on 6/05/2017.
 */
public class FileZillaClient {

    private String server;
    private int port;
    private String user;
    private String password;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFileFromFTPServer(){
       /* String server = "127.0.0.1";
        int port = 21;
        String user = "zoli";
        String pass = "zoli";*/

        String str = null;

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);


            //retrieve file from remote location
            String remoteFile = "/Inbox/HelloZoli.txt";

            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile);


            str = IOUtils.toString(inputStream, StandardCharsets.UTF_8);



            boolean success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File  has been downloaded successfully.");
            }

            inputStream.close();


        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return str;
    }

}
