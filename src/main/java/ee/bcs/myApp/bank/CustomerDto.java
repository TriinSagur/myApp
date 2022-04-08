package ee.bcs.myApp.bank;

import lombok.Data;

@Data
public class CustomerDto { // ainult klientide liigutamiseks tehtud klass
    private String firstName;
    private String lastName;
    private String isikukood;

}
