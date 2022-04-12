package ee.bcs.myApp.bank.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {
}