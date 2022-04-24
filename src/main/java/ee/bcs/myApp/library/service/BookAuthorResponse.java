package ee.bcs.myApp.library.service;

import lombok.Data;

@Data
public class BookAuthorResponse {

    private Integer id;
    private String bookTitle;
    private Integer bookYear;
    private String authorFirstName;
    private String authorLastName;
}
