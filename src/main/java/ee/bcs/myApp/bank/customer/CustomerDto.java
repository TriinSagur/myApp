package ee.bcs.myApp.bank.customer;


import lombok.Data;
import lombok.NonNull;



@Data
public class CustomerDto {

    private Integer id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String isikukood;

    public CustomerDto() {

    }
}
