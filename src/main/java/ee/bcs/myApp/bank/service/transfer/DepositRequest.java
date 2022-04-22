package ee.bcs.myApp.bank.service.transfer;

import lombok.Data;
import org.mapstruct.Mapping;

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
    @Max(500)
    private Integer amount;

}
