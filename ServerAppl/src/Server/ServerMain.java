package Server;

import Users.Client;
import Users.Thera;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        SocketHandler chat = new SocketHandler(1642, ServerMain::handleClientChat);
        chat.start();
        SocketHandler update = new SocketHandler(1643, ServerMain::handleClientUpdate);
        update.start();
        SocketHandler couns = new SocketHandler(1644, ServerMain::handleCounsellor);
    }


    private synchronized static void handleClientChat(Socket s) {
    }

    public static void handleClientUpdate(Socket s) {
        synchronized (ServerMain.class) {
            Client cl = new Client(s);
            int ID = Integer.valueOf(cl.read());
            cl.setID(ID);
            try {
                cl.write(new BufferedReader(new FileReader(cl.getFilepath())).readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleCounsellor(Socket s) {
        synchronized (available) {
            available.add(new Thera(s));
        }
    }
}
