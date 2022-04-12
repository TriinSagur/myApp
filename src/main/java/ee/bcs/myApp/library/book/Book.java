package ee.bcs.myApp.library.book;

import lombok.Data;

@Data
public class Book {
    public static Integer idCounter = 1;
    public Integer id;
    public String title;
    public Integer year;

    public void updateId() {
        id = idCounter;
        idCounter++;
    }
}
