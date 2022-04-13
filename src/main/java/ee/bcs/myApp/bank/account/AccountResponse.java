package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.customer.CustomerDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AccountResponse {

    private final Integer customerId;
    private String firstName;
    private String lastName;
    private String isikukood;
    private final String accountNumber;
    private final Integer balance;
    private final Boolean locked;
}
