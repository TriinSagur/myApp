package ee.bcs.myApp.library.bookAuthor;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BookAuthorDto implements Serializable {
    private Integer id;
    private Integer bookId;
    private Integer authorId;
    private String bookTitle;
    private Integer bookYear;
    private String authorFirstName;
    private String authorLastName;
}
