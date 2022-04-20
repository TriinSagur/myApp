package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
@Data
public class AccountResponse {    // DTO - Data Transfer Object klass

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String isikukood;
    private String accountNumber;
    private Integer balance;
    private Boolean locked;
}
