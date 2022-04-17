package ee.bcs.myApp.library.bookkeyword;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookKeywordDto implements Serializable {
    private Integer id;
    private Integer bookId;
    private String bookTitle;
    private Integer bookYear;
    private Integer keywordId;
}
