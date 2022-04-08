package ee.bcs.myApp.bank;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")

public class CustomerController {

    public static Bank bankRepository = new Bank();

    // UUe kliendi lisamine, Satatic on kõikides klassides olemas. Kõigi objektide vahel jagatud.
    // max 3 muutujat meetodis. 4 sissetulevat muutujat on juba plaju, hais tuleb juurde.
    // päris elus teeksime selleks uue klassi uue kliendi lisamiseks.

    @PostMapping("/add")
    @Operation(summary= "lisab uue kliendi")
    public Integer addNewCustomer(@RequestBody CustomerDto customerDto) {

        // Mapime customeri dto  väljad ümer customeri klassi
        //MAPstarct mäpib automaatselt ära need väljad mis on samade nimedega, erisusi kirjeldame annutatsioonidega.

        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());
        customer.updateId();

        List<Customer> customers = bankRepository.getCustomers();
        customers.add(customer);


        return customer.getId();

    }

    // list kõikidest klientidest, kes meil on. rada võiks olla nii selge kui saab olla.
    // vaata uue klassi loomise videot youtube

    @GetMapping("/all")
    @Operation(summary = "tagastab kõik kliendid")
    public List<Customer> getAllCustomers() {
        return bankRepository.getCustomers();

    }
    // ennem kutsume andmed välja ja siis teeme kustutamise
    // get eeldab, et midagi on olemas, find otsib kas on olemas
    // vaata video for List LOOP

    @GetMapping("/find")
    @Operation (summary = "leiab andmebaasi ID järgi kliendikoodi")
    public Customer findCustomerById(@RequestParam Integer id) {
        List<Customer> customers= bankRepository.getCustomers();

        Customer result = new Customer();

        for(Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;

            }
        }
        return result;
    }
    @DeleteMapping("/remove")
    public void removeCustomerId(@RequestParam Integer id) {
        List <Customer> customers= bankRepository.getCustomers();

        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }

        customers.remove(result);

    }
}
