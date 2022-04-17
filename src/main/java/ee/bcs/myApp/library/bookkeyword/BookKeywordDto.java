package ee.bcs.myApp.library.bookkeyword;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookKeywordDto implements Serializable {
    private final Integer id;
    private final Integer bookId;
    private final String bookTitle;
    private final Integer bookYear;
    private final Integer keywordId;
}
