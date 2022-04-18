package ee.bcs.myApp.library.author;


import ee.bcs.myApp.library.book.Book;
import ee.bcs.myApp.library.book.BookRepository;
import ee.bcs.myApp.library.bookauthor.BookAuthor;
import ee.bcs.myApp.library.bookauthor.BookAuthorRepository;
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

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookAuthorRepository bookAuthorRepository;


    public AuthorDto addNewAuthor(@RequestBody AuthorDto authorDto) {
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

    public void updateAuthorById(Integer id, AuthorDto authorDto) {
        Author author = authorRepository.getById(id);
        authorDto.setId(id);
        authorMapper.updateEntity(authorDto, author);
        authorRepository.save(author);
    }

}