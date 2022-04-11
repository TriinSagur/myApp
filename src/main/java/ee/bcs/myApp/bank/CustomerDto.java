package ee.bcs.myApp.bank;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String isikukood;
}
