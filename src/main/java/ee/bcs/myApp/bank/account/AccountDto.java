package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.CustomerDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AccountDto {
    private Integer id;

    @NotNull
    private Integer customerId;

    private CustomerDto customer;

    @NotNull
    @Size(min = 5, max = 5)
    private String accountNumber;

    private Integer balance = 0;
    private Boolean locked = false;

}
