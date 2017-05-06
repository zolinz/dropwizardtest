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

    public String getStuff(){
        String server = "127.0.0.1";
        int port = 21;
        String user = "zoli";
        String pass = "zoli";

        String str = null;

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);


            // APPROACH #2: using InputStream retrieveFileStream(String)
            String remoteFile2 = "/Inbox/HelloZoli.txt";
            File downloadFile2 = new File("D:/Downloads/song.mp3");
            StringBuilder sb = new StringBuilder();
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);


            str = IOUtils.toString(inputStream, StandardCharsets.UTF_8);



            boolean success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File #2 has been downloaded successfully.");
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
