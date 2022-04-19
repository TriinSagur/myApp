package ee.bcs.myApp.bank.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    void findByAccountNumber(String accountNumber);

    @Query("select a from Account a where upper(a.customer.lastName) = upper(?1) 
       Optional<Account> findByAccountNumberIgnoreCase(String accountNumber);




}