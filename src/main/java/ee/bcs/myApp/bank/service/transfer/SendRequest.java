package ee.bcs.myApp.bank.service.transfer;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SendRequest {
    @NotNull
    private Integer senderAccountId;
    @NotNull
    @Size(max = 11)
    private String receiverAccountNumber;
    @NotNull
    @Min(1)
    private Integer amount;

}
