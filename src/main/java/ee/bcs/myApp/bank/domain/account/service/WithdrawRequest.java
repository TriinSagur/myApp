package ee.bcs.myApp.bank.domain.account.service;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data // et oleks getterid-setterid-et saaks private parameetritele ligi
public class WithdrawRequest {
    @NotNull
    private Integer accountId;

    @NotNull
    @Min(1)
    private Integer amount;
}
