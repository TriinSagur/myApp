package ee.bcs.myApp.library.author;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDtos(authors);
    }

    public AuthorDto findAuthorById(Integer id) {
        Author author = authorRepository.getById(id);
        return authorMapper.toDto(author);
    }
}
