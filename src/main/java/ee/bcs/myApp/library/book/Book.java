package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.author.Author;
import lombok.Data;

import java.util.List;

@Data
public class Book {

    public static Integer idCounter = 1;
    private Integer id;
    private String title;
    private Integer year;
    private List<Author> authors;

    public void updateId() {
        id = idCounter;
        idCounter++;
    }

}
