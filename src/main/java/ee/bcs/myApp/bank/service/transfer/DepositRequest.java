package ee.bcs.myApp.bank.service.transfer;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Data
public class DepositRequest implements Serializable {

    @NotNull
    private Integer accountId;

    @NotNull
    @Min(1)
    private Integer amount;
}