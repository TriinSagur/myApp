
package ee.bcs.myApp.library.author;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AuthorDto implements Serializable {
    private Integer id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
