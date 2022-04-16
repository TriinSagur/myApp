package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Data
public class DepositRequest implements Serializable {


    @NotNull
    private Integer amount;
    @NotNull
    private Integer accountId;



}
