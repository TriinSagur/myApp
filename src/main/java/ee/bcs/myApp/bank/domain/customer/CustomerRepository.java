package ee.bcs.myApp.bank.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

// see on siin loodud üks uus interface.
// Me tegime selle IntelliJ abiga
// See klass on klassi JpaRepository pikendus.
// See tähendab seda, et selles CustomerRepository klassil on olemas kõik omadused ja meetodid,
// mis on olemas JpaRepository klassil.
// sinna JpaRepository<> klassi on kaasa antud ka entity klass Customer.
// seal siis juba tekivad vastavad seosed ja võimalused, millega saame vastavale tabelile ligi.
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // siia interface alla pole me ise ühtegi oma defineeritud meetodit juurde lisanud,
    // kuna piisas olemasolevatest JpaRepository meetoditest.
}