package ee.bcs.myApp.library.author;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthorService {
    public Integer addNewAuthor(AuthorDto authorDto) {
        Author author = toEntity(authorDto);
        author.updateId();

        // SIIT JÄI POOLELI
        return null;
    }

    private Author toEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return author;
    }
}
