package ee.bcs.myApp.bank.domain.account;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
@Data
public class AccountDto {    // DTO - Data Transfer Object klass
    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance = 0;
    private Boolean locked = false;
}
