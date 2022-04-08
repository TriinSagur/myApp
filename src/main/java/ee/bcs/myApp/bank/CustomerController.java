package ee.bcs.myApp.bank;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    public static Bank bankRepository = new Bank();

    @PostMapping("/add")
    @Operation(summary = "Lisa uus klient.")
    public Integer addNewCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setIsikukood(customer.getIsikukood());
        customer.updateId();

        List<Customer> customers = bankRepository.getCustomers();
        customers.add(customer);

        return customer.getId();
    }

    @GetMapping()
    @Operation(summary = "Tagastab kõik kliendid.")
    public List<Customer> getAllCustomers() {
        return bankRepository.getCustomers();
    }

    @GetMapping("/find")
    @Operation(summary = "Leiab kliendi andmebaasi ID järgi")
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

        customers.remove(result);
    }
}