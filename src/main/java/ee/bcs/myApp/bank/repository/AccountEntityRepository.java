package ee.bcs.myApp.bank.repository;

import ee.bcs.myApp.bank.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Integer> {
}