package ee.bcs.myApp.bank;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// selle klassi teeme ainult andemete liigutamiseks

@Data

public class CustomerDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min = 11, max = 11)
    private String isikukood;

}


