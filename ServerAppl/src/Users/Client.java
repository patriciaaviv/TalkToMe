package Users;

import Data.DiaryEntry;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Client {
    //filepath to folder with diary entry files
    private final String FILEPATH = "";
    private List<DiaryEntry> diary = new LinkedList<DiaryEntry>();
    private int ID;
    private String name;
    private Socket sock;

    public Client(Socket s, int ID, String name) {
        this.sock = s;
        this.ID = ID;
        this.name = name;
        this.parse();
    }

    private void parse() {
        //TODO Implement parser from file to diary list
    }
}
