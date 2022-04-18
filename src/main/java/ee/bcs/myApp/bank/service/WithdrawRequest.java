package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class WithdrawRequest implements Serializable {


    @NotNull
    private Integer accountId;

    @NotNull
    @Min(1)
    private Integer amount;
    }
