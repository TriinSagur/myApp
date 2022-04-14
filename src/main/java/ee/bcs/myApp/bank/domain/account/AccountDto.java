package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

@Data
public class AccountDto {
    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance;
    private Boolean locked = false;
}
