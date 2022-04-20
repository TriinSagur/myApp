package ee.bcs.myApp.bank.service;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MoneyRequest {

    @NotNull
    private String senderAccountNumber;
    @NotNull
    private String receiverAccountNumber;
    @NotNull
    private Integer amount;

}
