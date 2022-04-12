package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AuthorService {
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        Author author = toEntity(authorDto);
        author.updateId();
        List<Author> authors = MyAppApplication.libraryRepository.getAuthors();
        authors.add(author);
        return toDto(author);
    }

    private Author toEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return author;
    }

    private AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        return authorDto;
    }
}
