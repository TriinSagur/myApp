package ee.bcs.myApp.library.keyword;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-21T10:41:54+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class KeywordMapperImpl implements KeywordMapper {

    @Override
    public Keyword keywordDtoToKeyword(KeywordDto keywordDto) {
        if ( keywordDto == null ) {
            return null;
        }

        Keyword keyword = new Keyword();

        keyword.setId( keywordDto.getId() );
        keyword.setName( keywordDto.getName() );

        return keyword;
    }

    @Override
    public KeywordDto keywordToKeywordDto(Keyword keyword) {
        if ( keyword == null ) {
            return null;
        }

        Integer id = null;
        String name = null;

        id = keyword.getId();
        name = keyword.getName();

        KeywordDto keywordDto = new KeywordDto( id, name );

        return keywordDto;
    }

    @Override
    public List<KeywordDto> keywordToKeywordDtos(List<Keyword> keywords) {
        if ( keywords == null ) {
            return null;
        }

        List<KeywordDto> list = new ArrayList<KeywordDto>( keywords.size() );
        for ( Keyword keyword : keywords ) {
            list.add( keywordToKeywordDto( keyword ) );
        }

        return list;
    }

    @Override
    public void updateKeywordFromKeywordDto(KeywordDto keywordDto, Keyword keyword) {
        if ( keywordDto == null ) {
            return;
        }

        if ( keywordDto.getId() != null ) {
            keyword.setId( keywordDto.getId() );
        }
        if ( keywordDto.getName() != null ) {
            keyword.setName( keywordDto.getName() );
        }
    }
}
