package ee.bcs.myApp.library.bookAuthor;

import lombok.Data;

@Data
public class BookAuthorDto {
    private String bookTitle;
    private Integer bookYear;
    private String authorFirstName;
    private String authorLastName;
}
