package ee.bcs.myApp.bank.domain.customer;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
@Data
public class CustomerDto {

    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min = 11, max = 11)
    private String isikukood;
}
