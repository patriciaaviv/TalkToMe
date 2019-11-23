package Server;

import Users.Thera;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

//Main class on the server
public class ServerMain {

    //List of available, meaning online and not in Chat, counsellors
    private static List<Thera> available = new LinkedList<Thera>();

    //boolean if the program should continue running. Should always be true
    //Set to false in case something fatal happens in other threads or if you need to stop the program
    public static boolean run = true;

    //Main server method.
    public static void main(String[] args) throws IOException {

        //Starting new thread to handle the counsellor connections
        TheraHandler thh = new TheraHandler();
        thh.start();

        //New ServerSocket to wait for incoming clients
        ServerSocket in = new ServerSocket(1642);

        //Waiting fo client to connect then starting new thread to handle connection.
        while (run) {
            Socket client = in.accept();
            ServerThread thread = new ServerThread(client);
            thread.start();
        }
    }

    //Method to add new connected counsellor
    public static synchronized void addThera(Thera th) {
        available.add(th);
    }
}
