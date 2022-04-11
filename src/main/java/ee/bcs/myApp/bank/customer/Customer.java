package ee.bcs.myApp.bank.customer;

import lombok.Data;

@Data
public class Customer {
    public static Integer idCounter = 1;
    private Integer id;
    private String firstName;
    private String lastName;
    private String isikukood;

    public void updateId() {
        id = idCounter;
        idCounter++;

    }


}
