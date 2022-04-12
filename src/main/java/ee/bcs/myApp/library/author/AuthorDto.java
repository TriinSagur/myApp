package ee.bcs.myApp.library.author;

import lombok.Data;

import java.util.List;
@Data
public class AuthorDto {

    private String firstName;
    private String lastName;
    private List<Author> authors;
}
