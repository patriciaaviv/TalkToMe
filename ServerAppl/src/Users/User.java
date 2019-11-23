package Users;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public abstract class User {

    protected int ID;
    protected String name;
    protected Socket socket;
    protected BufferedReader in;
    protected BufferedWriter out;

    public User(Socket s) {
        socket = s;
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read() {
        String erg = null;
        synchronized (in) {
            try {
                erg = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return erg;
    }

    public void write(String str) {
        synchronized (out) {
            try {
                out.write(str + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
