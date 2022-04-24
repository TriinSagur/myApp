package ee.bcs.myApp.library.service;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookAuthorRequest implements Serializable {

    private String bookTitle;
    private Integer bookYear;
    private String authorFirstName;
    private String authorLastName;
}
