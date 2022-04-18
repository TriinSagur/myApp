package ee.bcs.myApp.library.bookauthor;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookAuthorDto implements Serializable {
//    private integer id;
//    private integer bookid;
    private String bookTitle;
    private Integer bookYear;
//    private Integer authorId;
    private String authorFirstName;
    private String authorLastName;
}
