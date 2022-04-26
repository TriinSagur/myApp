package ee.bcs.myApp.library.book;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BookDto implements Serializable {

    private final Integer id;
//    private Integer id;
    @NotNull
    private final String title;
//    private String title;
    @NotNull
    private final Integer year;
//    private Integer year;
}
