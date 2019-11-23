package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {


    public static boolean run = true;

    public static void main(String[] args) throws IOException {
        ServerSocket in = new ServerSocket(1642);
        while (run){
            Socket client = in.accept();
            ServerThread thread = new ServerThread(client);
        }
    }
}
