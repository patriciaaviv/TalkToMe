package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class SocketHandler extends Thread {

    private int port;
    private Consumer<Socket> func;

    public SocketHandler(int port, Consumer<Socket> con) {
        this.port = port;
        this.func = con;
    }

    public void run() {
        ServerSocket sock = null;
        try {
            sock = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (ServerMain.run) {
            Socket open = null;
            try {
                open = sock.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            func.accept(open);
        }
    }
}
