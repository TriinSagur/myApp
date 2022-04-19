package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class WithdrawRequest {

    @NotNull
    private Integer accountId;

    @Min(1)
    @NotNull
    private Integer amount;

}
