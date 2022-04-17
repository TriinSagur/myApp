package ee.bcs.myApp.library.book;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {
    private Integer id;
    private String title;
    private Integer year;
}
