package Server;

import Users.Thera;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Thread to handle counsellors connecting
public class TheraHandler extends Thread {

    //Main method. just waits for connection from the counsellor port.
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
                ServerMain.addThera(this.connect(t));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Method to establish connection and parse the received data, like ID, name, and maybe skillset
    private Thera connect(Socket s) {
        //TODO implement connection establishing and parsing of data
        return null;
    }
}
