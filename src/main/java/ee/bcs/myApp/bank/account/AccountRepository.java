package ee.bcs.myApp.bank.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where upper(a.customer.lastName) = upper(?1) order by a.customer.isikukood")
    List<Account> findByLastName(String lastName);





}