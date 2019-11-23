package Server;

import Users.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Main thread handling interaction between clients and server
public class ServerThread extends Thread {

    private Client client;
    private Thera th = null;

    //Initialise the client
    public ServerThread(Socket client) {
        //TODO Decide what to do
    }

    public void run() {
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(
                    sock.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int Id =
    }

}
