package ee.bcs.myApp.library.author;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class  AuthorService {

    @Resource
    private AuthorMapper authorMapper;

    @Resource
    AuthorRepository authorRepository;

    public AuthorDto addNewAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
        return authorMapper.toDto(author);
    }


    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDtos(authors);
    }

    public AuthorDto findAuthorById(Integer id) {
        Author author = authorRepository.getById(id);
        return authorMapper.toDto((author));
    }
    public AuthorDto findAuthorByLastName(String lastName) {
        Author author = authorRepository.getByLastName(lastName);
        return authorMapper.toDto((author));
    }

    public void removeAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthorById(Integer id, AuthorDto authorDto) {                         // ei tööta
        Author author = authorRepository.getById(id);
        Author entity = authorMapper.toEntity(authorDto);
        authorMapper.updateEntity(authorDto, entity);  // ei saa sellest aru
        authorRepository.save(author);

    }

    public void updateAuthorByLastName(String lastName, AuthorDto authorDto) {                  // ei tööta

        Author author = authorRepository.getByLastName(lastName);

        authorRepository.save(author);
    }

    public void removeAuthorByLastName(String lastName) {
        Author author = authorRepository.getByLastName(lastName);
        authorRepository.delete(author);

    }
}
