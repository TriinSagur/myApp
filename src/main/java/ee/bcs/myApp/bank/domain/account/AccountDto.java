package ee.bcs.myApp.bank.domain.account;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AccountDto {
    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance = 0;
    private Boolean locked = false;

}
