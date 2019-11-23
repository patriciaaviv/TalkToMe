import View.ChatWindow;
import View.MessageReciever;

import java.io.DataInputStream;
import java.net.Socket;

public class MessageSender implements Runnable {

    private ChatWindow window;
    private Socket socket;
    private DataInputStream receiveMessagesFromServerStream;
    public MessageSender(ChatWindow window, MessageReciever client){
        this.window=window;
        socket = client.socket;
        try {
            receiveMessagesFromServerStream = new DataInputStream(client.socket.getInputStream());
        } catch (Exception ioe) {
            System.out.println("Error getting input stream: " + ioe);
        }
    }
    @Override
    public void run() {
        while(true){
            try {
                window.partnerSentMessage(receiveMessagesFromServerStream.readUTF());
            }
            catch (Exception e){
                System.out.println("fail2");
            }
        }
    }
}
