package ee.bcs.myApp.library.author;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-16T15:17:04+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author authorToEntity(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDto.getId() );
        author.setFirstName( authorDto.getFirstName() );
        author.setLastName( authorDto.getLastName() );

        return author;
    }

    @Override
    public AuthorDto authorToDto(Author author) {
        if ( author == null ) {
            return null;
        }

        Integer id = null;
        String firstName = null;
        String lastName = null;

        id = author.getId();
        firstName = author.getFirstName();
        lastName = author.getLastName();

        AuthorDto authorDto = new AuthorDto( id, firstName, lastName );

        return authorDto;
    }

    @Override
    public List<AuthorDto> toDtos(List<Author> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( entities.size() );
        for ( Author author : entities ) {
            list.add( authorToDto( author ) );
        }

        return list;
    }

    @Override
    public void updateAuthorFromAuthorDto(AuthorDto authorDto, Author author) {
        if ( authorDto == null ) {
            return;
        }

        if ( authorDto.getId() != null ) {
            author.setId( authorDto.getId() );
        }
        if ( authorDto.getFirstName() != null ) {
            author.setFirstName( authorDto.getFirstName() );
        }
        if ( authorDto.getLastName() != null ) {
            author.setLastName( authorDto.getLastName() );
        }
    }
}
