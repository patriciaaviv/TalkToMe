import java.io.*;
import java.net.Socket;

public class TestSocket {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("131.159.210.149",1644);
            BufferedWriter writer = new BufferedWriter((new PrintWriter(socket.getOutputStream())));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                writer.write(br.readLine());
                writer.flush();
            }
        } catch(IOException io){
            System.out.println(io.toString());
        }
    }
}
