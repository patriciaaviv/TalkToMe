package Server;

import Users.Thera;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerMain {

    private List<Thera> thList = new LinkedList<Thera>();


    public static boolean run = true;

    public static void main(String[] args) throws IOException {
        ServerSocket in = new ServerSocket(1642);
        while (run) {
            Socket client = in.accept();
            ServerThread thread = new ServerThread(client);
        }
    }

    public synchronized void addThera(Thera th) {
        thList.add(th);
    }
}
