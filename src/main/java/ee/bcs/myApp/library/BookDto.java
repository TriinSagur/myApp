package ee.bcs.myApp.library;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDto {

    private Integer id;

    @NotNull
    private String title;
    @NotNull
//    @Size (min = 4, max = 4)
    private Integer year;

}
