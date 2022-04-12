package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.author.Author;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BookDto {
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private Integer year;
    @NotNull
    private List<Author> authors;
}
