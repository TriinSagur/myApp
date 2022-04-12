package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {


    public AuthorDto addNewAuthor(AuthorDto authorDto) {
        Author author = toEntity(authorDto);
        author.updateId();
        List<Author> authors = MyAppApplication.libraryRepository.getAuthors();
        authors.add(author);
        return toDto(author);
    }

    private AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        return authorDto;
    }

    private Author toEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return author;
    }
}
