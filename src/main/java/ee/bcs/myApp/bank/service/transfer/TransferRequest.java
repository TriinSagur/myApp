package ee.bcs.myApp.bank.service.transfer;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class TransferRequest {
    @NotNull
    @Size(max = 11)
    private String senderAccountNumber;
    @NotNull
    private String receiverAccountNumber;
    @NotNull
    @Min(1)
    private Integer amount;

}
