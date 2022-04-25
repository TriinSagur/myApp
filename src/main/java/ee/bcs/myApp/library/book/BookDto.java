package ee.bcs.myApp.library.book;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BookDto implements Serializable {
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private Integer year;
}
