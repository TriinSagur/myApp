package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.bank.account.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {
}