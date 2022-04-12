package ee.bcs.myApp.bank.customer;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
@Data
public class CustomerDto {
    // DTO - Data Transfer Object klass

    private Integer id;

    // valideerimise annotatsioonid.
    // Seda klassi luues ei saa selle muutuja väärtuseks jääda null
    // Sisse tuleva JSON'i puhul peab see väli olema täidetud
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min = 11, max = 11) // siin sätestatakse lubatud pikkus
    private String isikukood;
}
