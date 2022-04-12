package ee.bcs.myApp.library;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDto {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    @Size(max = 4)
    private Integer year;
}
