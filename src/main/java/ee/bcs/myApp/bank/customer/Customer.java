package ee.bcs.myApp.bank.customer;

import lombok.Data;

// Lombok'i annotatsioonid, mis loovad koodi kompileerimise hetkel vajalikud getterid ja setterid
// Kui getterite ja setterite teema on veel segane,
// siis palun vaata uuesti "Kasutaja poolt loodavad klassid"
// https://youtu.be/2kZn9_03two
@Data
public class Customer {
// See on sisuliselt Entity klass, mis peab vastama andmebaasis mingile kindlale tabelile

    public static Integer idCounter = 1;
    private Integer id;
    private String firstName;
    private String lastName;
    private String isikukood;

    // Enda poolt välja mõeldud meetod millega toimetame selle objekti andmetega
    public void updateId() {
        // Anname 'id' väljale 'idCounter' counter väärtuse
        id = idCounter;

        // Seejärel suurendame idCounteri suurust ühe võrra
        // Kui väärtuste inkrementeerimise teema on veel endiselt segane,
        // siis palun vaata uuesti "Muutujate ühe võrra suurendamine ja vähendamine (i++; i--; ++i; --i).":
        // https://youtu.be/uAD5bh2uFrQ
        idCounter++;
    }


}
