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
        Author author = authorMapper.authorToEntity(authorDto);
        authorRepository.save(author);

        return authorMapper.authorToDto(author);
    }

    public List<AuthorDto> findAllAuthors() {
        List<Author> allAuthors = authorRepository.findAll();

        return authorMapper.toDtos(allAuthors);
    }

    public AuthorDto findAuthorById(Integer id) {
        Author author = authorRepository.getById(id);

        return authorMapper.authorToDto(author);
    }



}
