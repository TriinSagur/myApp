package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MoneyRequest {
    @NotNull
    @Size(max = 11)
    private String senderaccountNumber;

    @NotNull
    @Size(max = 11)
    private String receiveraccountNumber;
    @NotNull
    @Min(1)
    private Integer amount;


}
