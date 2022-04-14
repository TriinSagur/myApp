package ee.bcs.myApp.bank.account;

import lombok.Data;


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
