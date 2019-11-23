import View.*;

import java.io.IOException;
import java.net.Socket;

public class Messenger{

    public static void main(String[] args) throws IOException {
        MessageReciever reciever = new MessageReciever("131.159.210.149", 1644);
        new Thread(reciever).start();
        ChatWindow window=new ChatWindow(reciever);
        MessageSender sender =new MessageSender(window,reciever);
        new Thread(sender).start();
    }

}
