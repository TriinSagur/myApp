package ee.bcs.myApp.library;

import lombok.Data;

@Data
public class BookDto {

    private static Integer idCounter;
    private Integer id;
    private String title;
    private Integer year;

}
