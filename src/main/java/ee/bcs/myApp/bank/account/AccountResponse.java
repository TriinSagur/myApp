package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.customer.CustomerDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AccountResponse {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String isikukood;
    private String accountNumber;
    private Integer balance;
    private Boolean locked;
}

