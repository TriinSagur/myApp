package ee.bcs.myApp.library.bookout;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookOutDto implements Serializable {
    private Integer id;
    private Integer bookId;
    private String bookTitle;
    private Integer bookYear;
    private Boolean isReturned;
}
