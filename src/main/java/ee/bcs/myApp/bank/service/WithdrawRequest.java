package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class WithdrawRequest {

    @Min(1)
    @NotNull
    private Integer amount;

    @NotNull
    private Integer accountId;
}
