package ee.bcs.myApp.bank.customer;

import lombok.Data;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
@Data
public class Customer {
// See on sisuliselt Entity klass, mis peab vastama andmebaasis mingile kindlale tabelile

    public static Integer idCounter = 1;
    private Integer id;
    private String firstName;
    private String lastName;
    private String isikukood;

    // Mingisugune meetod millega saab siin klassi sees andmetega toimeteda
    public void updateId() {
        id = idCounter;
        idCounter++;
    }


}
