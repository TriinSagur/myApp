package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.account.Account;
import ee.bcs.myApp.bank.account.AccountDto;
import ee.bcs.myApp.library.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    public List<AuthorDto> findAllAuthors() {
        Library libraryRepository = MyAppApplication.libraryRepository;
        List<Author> authors = libraryRepository.getAuthors();
        return null;
    }

    public AuthorDto addNewAuthor(AuthorDto authorDto) {
        Library libraryRepository = MyAppApplication.libraryRepository;
        List<Author> authors = libraryRepository.getAuthors();

        return authorDto;
    }

    private AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());

        return authorDto;
    }
}
