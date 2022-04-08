package ee.bcs.myApp.bank;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;


@Data
public class Customer {
    public static Integer idCounter = 1;
    private Integer id;
    private String firstName;
    private String lastName;
    private String isikukood;

    public void updateId() {
        id = idCounter;
        idCounter++;
    }


}
