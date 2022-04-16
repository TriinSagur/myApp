package ee.bcs.myApp.library.bookauthor;

import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;

@Data
public class BookAuthorDto implements Serializable {
    private final Integer id;
    @Valid
    private final String bookTitle;
    @Valid
    private final String authorFirstName;
    @Valid
    private final String authorLastName;
}
