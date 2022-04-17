package ee.bcs.myApp.library.bookout;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookOutDto implements Serializable {
    private final Integer id;
    private final BookDto book;
    private final Boolean isReturned;

    @Data
    public static class BookDto implements Serializable {
        private final Integer id;
        private final String title;
        private final Integer year;
    }
}
