package ee.bcs.myApp.library.bookauthor;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookAuthorDto implements Serializable {
    private final Integer id;
    private final Integer bookId;
    private final String bookTitle;
    private final Integer bookYear;
    private final Integer authorId;
    private final String authorFirstName;
    private final String authorLastName;
}
