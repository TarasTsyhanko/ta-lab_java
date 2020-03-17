package clientserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3349, 2);
        
        Socket s = server.accept();
        System.out.println("client connected...");
        PrintWriter writer = new PrintWriter(s.getOutputStream());
        writer.print("you online");
        writer.flush();

    }
}
