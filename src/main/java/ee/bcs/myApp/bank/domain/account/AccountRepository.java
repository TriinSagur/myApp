package ee.bcs.myApp.bank.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    // Tegime selle meetodi JPA Buddy abiga.
    // Tähtis on meeles pidada, et JPA tehnoloogia teeb meile ise taustal ära vajaliku SQL lause,
    // siis kas @Query annotatsiooni või siis meetodi nime nime põhjal.
    // Seega, see meetodi nimi peab olema täpselt õiges formaadis, või siis peab SQL koostamiseks lisama Query annotatsiooni
    // koos vastava päringu lausega. Muidu see JPA tehnoloogia ei toimi ja õiget SQL lauset kokku ei osata panna.
    @Query("select a from Account a where upper(a.customer.lastName) = upper(?1) order by a.accountNumber")
    List<Account> findByLastName(String lastName);
    
  

    
    
}