package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountDto implements Serializable {
    private final Integer id;
    private final Integer customerId;
    private final String accountNumber;
    private final Integer balance = 0;
    private final Boolean locked = false;
}
