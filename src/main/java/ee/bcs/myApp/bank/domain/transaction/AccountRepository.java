package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}