package ee.bcs.myApp.bank.account;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
@Data
public class AccountDto {
    // DTO - Data Transfer Object klass

    private Integer id;

    // valideerimise annotatsioonid.
    // Seda klassi luues ei saa selle muutuja väärtuseks jääda null
    // Sisse tuleva JSON'i puhul peab see väli olema täidetud
    @NotNull
    private Integer customerId;

    @NotNull
    @Size(min = 5, max = 5) // siin sätestatakse lubatud pikkus
    private String accountNumber;

    private Integer balance = 0;
    private Boolean locked = false;

}
