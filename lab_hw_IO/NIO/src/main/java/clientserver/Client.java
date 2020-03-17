package clientserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import readcomments.Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3349);
        DataInputStream d = new DataInputStream(socket.getInputStream());
        StringBuilder sb = new StringBuilder();
        while (d.available()>0){
            byte b = d.readByte();
            sb.append((char)b);
        }
        LOG.info("server: " + sb.toString());

        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        LOG.info("YOU: ");
        String s = new Scanner(System.in).nextLine();
        LOG.info("......" + s);
        writer.println(s);
        writer.flush();
    }
}

