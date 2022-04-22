package ee.bcs.myApp.bank.domain.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("select t from Transaction t where t.account.id = ?1 order by t.transactionDateTime DESC")
    List<Transaction> findTransactionsByAccountId(Integer accountId);


}