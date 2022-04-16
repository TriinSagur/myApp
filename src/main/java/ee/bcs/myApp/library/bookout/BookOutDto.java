package ee.bcs.myApp.library.bookout;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookOutDto implements Serializable {
    private final Integer id;
    private final Integer bookId;
    private final String bookTitle;
    private final Integer bookYear;
    private final Boolean isReturned;
}
