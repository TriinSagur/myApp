package ee.bcs.myApp.bank.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntiryRepository extends JpaRepository<CustomerEntiry, Integer> {
}