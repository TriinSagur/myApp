package ee.bcs.myApp.library.keyword;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-17T11:52:43+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Amazon.com Inc.)"
)
@Component
public class KeywordMapperImpl implements KeywordMapper {

    @Override
    public Keyword toEntity(KeywordDto keywordDto) {
        if ( keywordDto == null ) {
            return null;
        }

        Keyword keyword = new Keyword();

        keyword.setName( keywordDto.getName() );

        return keyword;
    }

    @Override
    public KeywordDto toDto(Keyword keyword) {
        if ( keyword == null ) {
            return null;
        }

        KeywordDto keywordDto = new KeywordDto();

        keywordDto.setId( keyword.getId() );
        keywordDto.setName( keyword.getName() );

        return keywordDto;
    }

    @Override
    public List<KeywordDto> toDtos(List<Keyword> keywords) {
        if ( keywords == null ) {
            return null;
        }

        List<KeywordDto> list = new ArrayList<KeywordDto>( keywords.size() );
        for ( Keyword keyword : keywords ) {
            list.add( toDto( keyword ) );
        }

        return list;
    }

    @Override
    public void updateEntity(KeywordDto keywordDto, Keyword keyword) {
        if ( keywordDto == null ) {
            return;
        }

        if ( keywordDto.getName() != null ) {
            keyword.setName( keywordDto.getName() );
        }
    }
}