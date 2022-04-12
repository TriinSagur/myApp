package ee.bcs.myApp.library.author;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthorDto {

    private Integer id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
