package ee.bcs.myApp.library.author;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-23T12:23:16+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorDto authorDto) {
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
    public AuthorDto toDto(Author author) {
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

    @Override
    public List<AuthorDto> toDtos(List<Author> authors) {
        if ( authors == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( authors.size() );
        for ( Author author : authors ) {
            list.add( toDto( author ) );
        }

        return list;
    }
}
