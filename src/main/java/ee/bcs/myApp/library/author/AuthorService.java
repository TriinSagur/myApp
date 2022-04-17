package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.customer.CustomerDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthorService {

    @Resource
    private AuthorMapper authorMapper;

    @Resource
    private AuthorRepository authorRepository;

    public AuthorDto addNewAuthor(AuthorDto authorDto) {
        Author author = authorMapper.authorDtoToAuthor(authorDto);
        authorRepository.save(author);
        return authorMapper.authorToAuthorDto(author);
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> allAuthors = authorRepository.findAll();
        return authorMapper.authorToAuthorDtos(allAuthors);
    }

    public AuthorDto findAuthorById(Integer id) {
        Author author = authorRepository.getById(id);
        return authorMapper.authorToAuthorDto(author);
    }

    public void removeAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthorById(Integer id, AuthorDto authorDto) {
        Author author = authorRepository.getById(id);
        authorMapper.updateAuthorFromAuthorDto(authorDto, author);
        authorRepository.save(author);
    }
}
