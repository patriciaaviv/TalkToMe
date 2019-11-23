
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;


public class ChatClient {

    public static final int ID = 42;

    public static void main(String[] args) {

        Socket server = new Socket();

        try {
            server = new Socket("127.0.0.1", 1643);
            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream());
            out.write(ID+"\n");
            String temp = reader.readLine();
            long latestDate = Long.parseLong(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}