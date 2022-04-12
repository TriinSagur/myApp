package ee.bcs.myApp.library.author;

import lombok.Data;

@Data
public class Author {

    private static Integer idCounter = 1;
    private Integer id;
    private String firstName;
    private String lastName;


    public void updateId () {
        id = idCounter;
        idCounter++;
    }




}
