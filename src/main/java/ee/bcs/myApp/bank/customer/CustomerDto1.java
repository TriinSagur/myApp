package ee.bcs.myApp.bank.customer;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDto1 implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String isikukood;
}
