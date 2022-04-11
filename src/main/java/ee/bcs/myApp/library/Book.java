package ee.bcs.myApp.library;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    public static Integer idCounter = 1;
    private Integer id;
    private String title;
    private Integer year;
//    List<Author> authors;

    public void updateId () {
        id = idCounter;
        idCounter++;
    }
}
