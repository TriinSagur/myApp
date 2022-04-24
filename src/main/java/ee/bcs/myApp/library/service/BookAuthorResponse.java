package ee.bcs.myApp.library.service;

import lombok.Data;

@Data
public class BookAuthorResponse {

    private Integer bookId;
    private String bookTitle;
    private Integer bookYear;
    private Integer authorId;
    private String authorFirstName;
    private String authorLastName;
}
