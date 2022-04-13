package ee.bcs.myApp.bank.account;

import lombok.Data;

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
