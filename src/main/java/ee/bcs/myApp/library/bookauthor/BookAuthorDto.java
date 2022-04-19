package ee.bcs.myApp.library.bookauthor;

import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;

@Data
public class BookAuthorDto implements Serializable {
    private Integer id;
    @Valid
    private String bookTitle;

    private Integer bookYear;
    @Valid
    private String authorFirstName;
    @Valid
    private String authorLastName;
}
