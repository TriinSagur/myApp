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


    public AuthorDto addNewAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    public List<AuthorDto> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDtos(authors);
    }

    public AuthorDto findAuthorById(Integer id) {
        Author author = authorRepository.getById(id);
        return authorMapper.toDto(author);
    }

    public void removeAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthorById(Integer authorId, AuthorDto authorDto) {
        Author author = authorRepository.getById(authorId);
        authorMapper.updateEntity(authorDto,author);
        authorRepository.save(author);
    }
}
