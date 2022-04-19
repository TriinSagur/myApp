package ee.bcs.myApp.library.bookauthor;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookAuthorDto implements Serializable {

    private String bookTitle;
    private Integer bookYear;

    private String authorFirstName;
    private String authorLastName;
}
