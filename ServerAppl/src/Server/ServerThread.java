package Server;

import Users.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedDeque;

//Main thread handling interaction between clients and server
public class ServerThread extends Thread {

    private Client client;
    private Thera th = null;
    private String mode = null;
    private Socket clSocket;

    //Initialise the client
    public ServerThread(Socket client) throws IOException {
        clSocket = client;
    }

    //Method running the chat itself
    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    clSocket.getInputStream()));
            this.initialise(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO implement logic for update and chat
        //TODO implement interaction with azure
    }

    private void initialise(BufferedReader in) throws IOException {
        mode = in.readLine();
        //client = new Client(Integer.valueOf(in.readLine()), in.readLine());
    }

}
