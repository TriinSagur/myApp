package ee.bcs.myApp.bank.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select (count(c) > 0) from Customer c where upper(c.isikukood) = upper(?1)")
    boolean existsByIsikukood(String isikukood);


}