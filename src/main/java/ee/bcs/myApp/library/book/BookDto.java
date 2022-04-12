package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.author.Author;
import lombok.Data;
import lombok.NonNull;

@Data
public class BookDto {

    private Integer id;

    @NonNull
    private String title;

    @NonNull
    private Integer year;

    public BookDto() {

    }
}
