package filetransfer;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.xfer.FileSystemFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by Zoli on 7/05/2017.
 */
public class MySftpClient {

    public String getFile() throws IOException{

        String content = null;
        final SSHClient ssh = new SSHClient();
        ssh.loadKnownHosts();
        ssh.addHostKeyVerifier("52:e5:4b:c6:c6:f8:53:b8:7c:b2:2c:9f:b6:dc:fe:91");
        ssh.connect("127.0.0.1", 22);

        try {
            //ssh.authPublickey(System.getProperty("user.name"));
            ssh.authPassword("zoli", "zoli");
            final SFTPClient sftp = ssh.newSFTPClient();
            try {
                File downloadedFile = new File("C:\\temp\\HelloZoli.txt");
                downloadedFile.delete();

                String fileName = "HelloZoli.txt";
                sftp.get("HelloZoli.txt", new FileSystemFile("C:\\temp"));




                String sCurrentLine;

                BufferedReader br = new BufferedReader(new FileReader(downloadedFile));


                StringBuilder sb = new StringBuilder();
                while ((sCurrentLine = br.readLine()) != null) {
                    sb.append(sCurrentLine);
                }


                content = sb.toString();

                downloadedFile.delete();

            } finally {
                sftp.close();
            }
        } finally {
            ssh.disconnect();
        }
        return content;
    }


}
