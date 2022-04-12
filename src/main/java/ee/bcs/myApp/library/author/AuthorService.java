package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import ee.bcs.myApp.library.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

//    public List<AuthorDto> findAllAuthors() {
//        Library libraryRepository = MyAppApplication.libraryRepository;
//        List<Author> authors = libraryRepository.get.Authors();
//
//        List<AuthorDto> authorDtos = new ArrayList<>();
//        for (Author author : authors) {
//            AuthorDto authorDto = toDto(author);
//            authorDto.add(authorDto);
//        }
//        return authorDtos;
//    }
//
//    public AuthorDto addNewAuthor(AuthorDto authorDto) {
//        Author author = toEntity(authorDto);
//        author.updateId();
//        List<Author> authors = MyAppApplication.libraryRepository.getAuthors();
//        authors.add(author);
//        return authorDto;
//    }
//
//    private Author toEntity(AuthorDto authorDto) {
//        Author author = new Author();
//        author.setFirstName(authorDto.getFirstName());
//        author.setLastName(authorDto.getLastName());
//        return author;
//    }
}
