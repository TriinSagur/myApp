package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.bookauthor.BookAuthor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private Integer year;
}
