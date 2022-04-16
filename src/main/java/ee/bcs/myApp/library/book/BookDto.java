package ee.bcs.myApp.library.book;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookDto {


    @NotNull
    private String title;

    @NotNull
    private Integer year;

    private Integer id;

}
