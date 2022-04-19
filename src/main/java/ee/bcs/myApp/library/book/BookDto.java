package ee.bcs.myApp.library.book;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {
    private final Integer id;
    private final String title;
    private final Integer year;
}
