package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountDto implements Serializable {
    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance = 0;
    private Boolean locked = false;
}
