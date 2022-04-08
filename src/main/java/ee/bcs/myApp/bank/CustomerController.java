package ee.bcs.myApp.bank;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    public static Bank bankRepository = new Bank();

    @PostMapping("/add")
    @Operation(summary = "lisab uue kliendi")
    public Integer addNewCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());

        customer.updateId();

        List<Customer> customers = bankRepository.getCustomers();  // teeme panga depo
        customers.add(customer);  // lisame kliendi

        return customer.getId();
    }

    @GetMapping("/all")
    @Operation(summary = "tagastab kõik kliendid")
    public List<Customer> getAllCustomers() {

        return bankRepository.getCustomers();
    }

    @GetMapping("/find-customer")
    @Operation(summary = "leiame andmebaasi ID järgi kliendi")
    public Customer findCustomerById(@RequestParam Integer id) {
        List<Customer> customers = bankRepository.getCustomers();

        Customer result = new Customer();

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }
        return result;
    }

    @DeleteMapping("/remove")
    public void removeCustomerById(@RequestParam Integer id) {
        List<Customer> customers = bankRepository.getCustomers();

        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }


    }

}
