package ee.bcs.myApp.library.author;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDto implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
}
