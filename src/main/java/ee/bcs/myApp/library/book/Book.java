package ee.bcs.myApp.library.book;

import lombok.Data;

@Data

public class Book {

    public Integer id;
    public String title;
    public Integer year;
    public String authors;

   /* public void upDateId() {
        id = idCounter;
        idCounter++;

    }*/
}
