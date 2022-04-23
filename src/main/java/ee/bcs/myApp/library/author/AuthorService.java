package ee.bcs.myApp.library.author;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthorService {

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private AuthorMapper authorMapper;


    public AuthorDto getAuthorById(Integer id) {
        Author author = authorRepository.getById(id);
        return authorMapper.toDto(author);
    }

    public List<AuthorDto> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDtos(authors);
    }

    public AuthorDto addNewAuthor(Author author) {
        Author newAuthor = new Author();
        newAuthor.setFirstName(author.getFirstName());
        newAuthor.setLastName(author.getLastName());
        authorRepository.save(newAuthor);
        return authorMapper.toDto(newAuthor);
    }

    public void deleteAuthorByLastName(String lastName) {
        authorRepository.deleteByLastName(lastName);
    }

    public void updateAuthorById(Integer id, AuthorDto authorDto) {
        Author foundAuthor = authorRepository.getById(id);
        authorMapper.updateAuthorFromAuthorDto(authorDto, foundAuthor);
        authorRepository.save(foundAuthor);

    }
}
