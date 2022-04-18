package ee.bcs.myApp.library.book;

import ee.bcs.myApp.library.bookauthor.BookAuthorDto;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NewBookRequest {

    private BookAuthorDto bookAuthorDto;

    @NotNull
    private String title;
    @NotNull
//    @Size (min = 4, max = 4)
    private Integer year;

}
