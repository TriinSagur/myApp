package ee.bcs.myApp.library.bookkeyword;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookKeywordDto implements Serializable {
    private final Integer id;
    private final Integer book_id;
    private final Integer keyword_id;
}
