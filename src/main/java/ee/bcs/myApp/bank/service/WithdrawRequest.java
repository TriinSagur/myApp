package ee.bcs.myApp.bank.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class WithdrawRequest {

    @NotNull
    private Integer accountId;

    @NotNull
    @Min(1)
    private Integer amount;
}
