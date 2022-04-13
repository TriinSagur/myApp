package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.customer.CustomerDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {
    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        Author author = toEntity(authorDto);
        author.updateId();
        List<Author> authors = MyAppApplication.libraryRepository.getAuthors();
        authors.add(author);
        return toDto(author);
    }

    public List<AuthorDto> findAllAuthors() {
        List<Author> authors = MyAppApplication.libraryRepository.getAuthors();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authors) {
            AuthorDto authorDto = toDto(author);
            authorDtos.add(authorDto);
        }
        return authorDtos;

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
