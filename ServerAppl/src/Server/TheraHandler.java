package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TheraHandler extends Thread {

    public void run() {
        ServerSocket serv = null;
        try {
            serv = new ServerSocket(1643);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (ServerMain.run) {
            try {
                Socket t = serv.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
