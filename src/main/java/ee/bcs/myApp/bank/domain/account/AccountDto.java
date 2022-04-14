package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class AccountDto {
    private final Integer id;
    private final Integer customerId;
    private final String accountNumber;
    private final Integer balance = 0;
    private final Boolean locked = false;

}
