package ee.bcs.myApp.library.author;

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
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
        return authorMapper.toDto(author);
    }


    public List<AuthorDto> returnAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDtos(authors);
    }

    public AuthorDto findAuthorById(Integer id) {
        Author Author = authorRepository.getById(id);
        return authorMapper.toDto(Author);
    }

    public void removeAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }


    public void updateAuthorById(Integer id, AuthorDto authorDto) {
        Author author = authorRepository.getById(id);
        authorMapper.updateAuthorFromAuthorDto(authorDto,author);
        authorRepository.save(author);
    }
}