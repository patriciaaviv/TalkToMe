import Server.ServerMain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TESTMain {

    public static void main(String[] args) throws IOException {
        ServerSocket kek = new ServerSocket(1642);
        Socket k = kek.accept();
        ServerMain.handleClientUpdate(k);
    }
}
