package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

@Data
public class AccountResponse {

    private final Integer customerId;
    private final String firstName;
    private final String lastName;
    private final String isikukood;
    private final String accountNumber;
    private final Integer balance;
    private final Boolean locked;


}
