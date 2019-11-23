package View;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MessageReciever implements Runnable, MessageHandler {

    public Socket socket;
    private DataInputStream readFromConsoleStream = null;
    boolean active = true;
    private DataOutputStream sendToServerStream = null;

    public MessageReciever(final String serverName, final int serverPort) {
        try {
            socket = new Socket(serverName,serverPort);
            readFromConsoleStream = new DataInputStream(System.in);
            sendToServerStream=new DataOutputStream(socket.getOutputStream());
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    @Override
    public void run() {
        while(true){

        }
    }

    @Override
    public void userSentMessage(String message) {
        try{
            sendToServerStream.writeUTF(message);
            sendToServerStream.flush();
        }catch(Exception e){
            System.out.println("fail");
        }
    }
}
