package ee.bcs.myApp.library.book;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookDto {

    private Integer id;

    @NotNull
    private String title;
    @NotNull
//    @Size (min = 4, max = 4)
    private Integer year;

}
