package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

@Data
public class AccountResponse {

    private Integer accountId;
    private final Integer customerId;
    private String firstName;
    private String lastName;
    private String isikukood;
    private final String accountNumber;
    private final Integer balance;
    private final Boolean locked;
}
