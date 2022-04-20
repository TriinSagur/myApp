package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MoneyRequest {
    @NotNull
    @Size(max = 11)
    private String senderAccountNumber;

    @NotNull
    @Size(max = 11)
    private String receiverAccountNumber;


    @NotNull
    private Integer amount;

}
