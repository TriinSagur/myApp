package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Data
public class DepositRequest implements Serializable {

    @NotNull
    private final Integer accountId;
    @Min(1)
    @Max(50000)
    private final Integer amount;
}
