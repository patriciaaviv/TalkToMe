package Users;

import Data.DiaryEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Client extends User {
    //filepath to folder with diary entry files
    private final static String FILEPATH = "Diaries\\";
    private List<DiaryEntry> diary = new LinkedList<DiaryEntry>();

    public Client(Socket s) {
        super(s);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFilepath() {
        return FILEPATH + ID + ".txt";
    }

    //method to parse the data from the file to a diary entry list.
    public void parse() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(getFilepath()));,
        in.readLine();
        in.readLine();
        String c = in.readLine();
        List<DiaryEntry> diary = new ArrayList<DiaryEntry>();
        while (!c.equals("end")) {
            Date d = new Date(Long.parseLong(c));
            StringBuffer sb = new StringBuffer("");
            while
        }
    }

    //Method to end connection/write log to diary
    public void close() {

    }
}
