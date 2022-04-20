package ee.bcs.myApp.bank.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// see on siin loodud üks uus interface.
// Me tegime selle IntelliJ abiga
// See klass on klassi JpaRepository pikendus.
// See tähendab seda, et selles AccountRepository klassil on olemas kõik omadused ja meetodid,
// mis on olemas JpaRepository klassil.
// sinna JpaRepository<> klassi on kaasa antud ka entity klass Account.
// seal siis juba tekivad vastavad seosed ja võimalused, millega saame vastavale tabelile ligi.
public interface AccountRepository extends JpaRepository<Account, Integer> {

    // Tegime selle meetodi JPA Buddy abiga.
    // Tähtis on meeles pidada, et JPA tehnoloogia teeb meile ise taustal ära vajaliku SQL lause,
    // siis kas @Query annotatsiooni või siis meetodi nime nime põhjal.
    // Seega, see meetodi nimi peab olema täpselt õiges formaadis, või siis peab SQL koostamiseks lisama Query annotatsiooni
    // koos vastava päringu lausega. Muidu see JPA tehnoloogia ei toimi ja õiget SQL lauset kokku ei osata panna.
    // Kui JPA repository teema on veel endiselt segane, siis palun vaata uuesti "JPA Buddy controller + create repository methods":
    // https://youtu.be/kMR8PzaCp0Y
    @Query("select a from Account a where upper(a.customer.lastName) = upper(?1) order by a.accountNumber")
    List<Account> findByLastName(String lastName);

    // Sama põhimõte mis eelmiesel.
    // JPA Buddy's valisime Wrap type optionis valiku (Optional)
    // Tänu sellele mähitakse tulemus Optionali sisse.
    // See on hea kuna Optional klassil on olemas mõned head meetodid nagu näiteks isEmpty() ja isPresent()
    // Kui JPA repository teema on veel endiselt segane, siis palun vaata uuesti "JPA Buddy controller + create repository methods":
    // https://youtu.be/kMR8PzaCp0Y
    @Query("select a from Account a where upper(a.accountNumber) = upper(?1)")
    Optional<Account> findByAccountNumber(String accountNumber);

    @Query("select (count(a) > 0) from Account a where upper(a.accountNumber) = upper(?1)")
    boolean existsByAccountNumber(String accountNumber);




}