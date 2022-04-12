package ee.bcs.myApp.library.book;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookDto {

    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private Integer year;

}
