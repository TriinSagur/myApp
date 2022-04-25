package ee.bcs.myApp.library.author;

import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.bookauthor.BookAuthorDto;
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

    public AuthorDto addNewAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    public void deleteAuthorByLastName(String lastName) {
        authorRepository.deleteByLastName(lastName);
    }

    public void updateAuthorById(Integer id, AuthorDto authorDto) {
        Author foundAuthor = authorRepository.getById(id);
        authorMapper.updateEntity(authorDto, foundAuthor);
        authorRepository.save(foundAuthor);
    }

    public Author getAndSaveAuthor(BookAuthorDto bookAuthorDto) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName(bookAuthorDto.getAuthorFirstName());
        authorDto.setLastName(bookAuthorDto.getAuthorLastName());
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
        return author;
    }


    public Author getAuthorEntityById(Integer authorId) {
        return authorRepository.getById(authorId);
    }
}
