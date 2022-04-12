package ee.bcs.myApp.bank.account;


import lombok.Data;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
@Data
public class Account {
// See on sisuliselt Entity klass, mis peab vastama andmebaasis mingile kindlale tabelile

    public static Integer idCounter = 1;

    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance;
    private Boolean locked;

    // Mingisugune meetod millega saab siin klassi sees andmetega toimeteda
    public void updateId() {
        id = idCounter;
        idCounter++;
    }

}
