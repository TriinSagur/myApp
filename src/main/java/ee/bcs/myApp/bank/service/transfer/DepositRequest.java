package ee.bcs.myApp.bank.service.transfer;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DepositRequest implements Serializable {

    @NotNull
    @Min(1)

    private Integer amount;

    @NotNull
    private Integer accountId;
}
