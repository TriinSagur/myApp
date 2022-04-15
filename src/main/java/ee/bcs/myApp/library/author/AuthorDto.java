package ee.bcs.myApp.library.author;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
}
