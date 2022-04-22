package ee.bcs.myApp.library.author;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-21T11:10:10+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
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

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( author.getId() );
        authorDto.setFirstName( author.getFirstName() );
        authorDto.setLastName( author.getLastName() );

        return authorDto;
    }

    @Override
    public List<AuthorDto> toDtos(List<Author> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( entities.size() );
        for ( Author author : entities ) {
            list.add( toDto( author ) );
        }

        return list;
    }

    @Override
    public void updateEntity(AuthorDto authorDto, Author author) {
        if ( authorDto == null ) {
            return;
        }

        if ( authorDto.getFirstName() != null ) {
            author.setFirstName( authorDto.getFirstName() );
        }
        if ( authorDto.getLastName() != null ) {
            author.setLastName( authorDto.getLastName() );
        }
    }
}
