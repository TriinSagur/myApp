package ee.bcs.myApp.bank;


import lombok.Data;

@Data
public class CustomerDto {
    private static Integer idCounter;
    private Integer id;
    private String firstName;
    private String lastName;
    private String isikukood;
}
