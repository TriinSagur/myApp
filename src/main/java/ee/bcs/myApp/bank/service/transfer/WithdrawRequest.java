package ee.bcs.myApp.bank.service.transfer;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Data
public class WithdrawRequest {
    @NotNull
    private Integer accountId;

    @NotNull
    @Min(1)
    private  Integer amount;
}
