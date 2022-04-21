package ee.bcs.myApp.library.bookauthor;

import lombok.Data;

@Data
public class AddAuthorToBook {
    private Integer bookId;
    private Integer authorId;
}
