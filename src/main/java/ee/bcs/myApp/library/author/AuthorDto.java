package ee.bcs.myApp.library.author;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AuthorDto implements Serializable {
    private final Integer id;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;

}
