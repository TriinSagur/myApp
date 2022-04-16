package ee.bcs.myApp.library.author;

import ee.bcs.myApp.library.book.BookDto;
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

    public List <AuthorDto> getAllAuthors() {
        List<Author> allAuthors = authorRepository.findAll();
        return authorMapper.toDtos(allAuthors);
    }

    public AuthorDto findAuthorById(Integer id) {
        Author author = authorRepository.getById(id);
        return authorMapper.toDto(author);
    }

    public void removeAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthorById(Integer id, AuthorDto authorDto) {
        Author author = authorRepository.getById(id);
        authorMapper.updateEntity(authorDto, author);
        authorRepository.save(author);
    }
}
