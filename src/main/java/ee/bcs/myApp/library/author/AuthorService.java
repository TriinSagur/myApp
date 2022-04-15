package ee.bcs.myApp.library.author;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Resource
    private AuthorMapper authorMapper;

    @Resource
    private AuthorRepository authorRepository;


    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    public List<AuthorDto> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDtos(authors);

    }

//    private Author toEntity(AuthorDto authorDto) {
//        Author author = new Author();
//        author.setId(authorDto.getId());
//        author.setFirstName(authorDto.getFirstName());
//        author.setLastName(authorDto.getLastName());
//        return author;
//    }

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
//
//    private AuthorDto toDto(Author author) {
//        AuthorDto authorDto = new AuthorDto();
//        authorDto.setId(author.getId());
//        authorDto.setFirstName(author.getFirstName());
//        authorDto.setLastName(author.getLastName());
//        return authorDto;
//    }
//
//
}
