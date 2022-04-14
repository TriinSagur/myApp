package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DepositRequest implements Serializable {
    @Min(1)
    @Max(5000)
    @NotNull
    private Integer amount;
    @NotNull
    private Integer accountId;
}
