package ee.bcs.myApp.library.author;


import lombok.Data;

@Data
public class Author {
    public  static Integer idCounter = 1;
    public Integer id;
    public String firstName;
    public String lastName;

    public  void updateId() {
        id = idCounter;
        idCounter++;
    }
}
