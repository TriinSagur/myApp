package ee.bcs.myApp.library;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class Lending {

    public Integer id;
    public String title;
    public String authors;
    public Integer year;
    public LocalDateTime lendingDateTime;
    public  String theLender;




}
