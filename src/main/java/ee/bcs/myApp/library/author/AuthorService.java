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

    public AuthorDto findAuthorByLastName(String lastName) {
        Author author = authorRepository.findAuthorByLastName(lastName);
        return authorMapper.toDto(author);
//        TODO: vastus kui ei ole leitud
    }

    public String deleteAuthorByLastName(String lastName) {

        List<Author> authors = authorRepository.findAll();

        String response = null;
        for (Author author : authors) {
            if (author.getLastName().equals(lastName)) {
                authorRepository.deleteAuthorByLastName(lastName);

                response = author.getFirstName() + " " + author.getLastName() + " is removed";
            } else {
                response = "Author with " + lastName + " last name was not found";
            }

        }

        return response;
    }

    public void updateAuthorById(Integer id, AuthorDto authorDto) {
        Author author = authorRepository.getById(id);
        authorMapper.updateAuthorFromAuthorDto(authorDto, author);
        authorRepository.save(author);
    }
}
