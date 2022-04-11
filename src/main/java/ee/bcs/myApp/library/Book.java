package ee.bcs.myApp.library;


import lombok.Data;

@Data
public class Book {
    public static Integer idCounter = 1;
    private Integer id;
    private String title;
    private Integer year;

    public void updateId(){
        id=idCounter;
        idCounter++;
    }
}
