package ee.bcs.myApp.bank.account;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
public class AccountDto {

    private Integer id;

    @NonNull
    private Integer customerId;


    @NonNull
    @Size(min = 5, max = 5)
    private Integer accountNumber;

    @NonNull
    private Integer balance = 0;

    @NonNull
    private Boolean locked = false;

    public AccountDto() {

    }
}
