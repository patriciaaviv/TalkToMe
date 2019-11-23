package Server;

import Users.*;

import java.net.Socket;

public class ServerThread extends Thread {

    private Client client;
    private Socket sock;
    private Thera th = null;

    public ServerThread(Socket c) {
        sock = c;
    }

    public void run() {

    }

}
