package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.author.AuthorDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookAuthorDto implements Serializable {
    private final Integer id;
    private final Author book;
    private final AuthorDto author;
}
