package Data;

import java.util.Date;
//Interface fo Diary Entries.
public interface DiaryEntry {
    //All entries must have a date to be sorted and to be defined
    public Date date = new Date(System.currentTimeMillis());
}
