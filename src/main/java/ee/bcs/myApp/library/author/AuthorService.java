//package ee.bcs.myApp.library.author;
//
//import ee.bcs.myApp.MyAppApplication;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class AuthorService {
//
//
//    public AuthorDto addNewAuthor(AuthorDto authorDto) {
//
//        Author author = toEntity(authorDto);
//
//        List<Author> authors = MyAppApplication.libraryRepository.getAuthors();
//        authors.add(author);
//
//        return toDto(author);
//
//
//    }
//
//    private AuthorDto toDto(Author author) {
//        AuthorDto authorDto = new AuthorDto();
//        authorDto.setId(author.getId());
//        authorDto.setFirstName(author.getFirstName());
//        authorDto.setLastName(author.getLastName());
//        return authorDto;
//    }
//
//    private Author toEntity(AuthorDto authorDto) {
//        Author author = new Author();
//        author.setId(authorDto.getId());
//        author.setFirstName(authorDto.getFirstName());
//        author.setLastName(authorDto.getLastName());
//        return author;
//    }
//
//    public AuthorDto findAuthorById(Integer id) {
//
//        List<Author>authors = MyAppApplication.libraryRepository.getAuthors();
//
//
//
//        return null;
//    }
//}
