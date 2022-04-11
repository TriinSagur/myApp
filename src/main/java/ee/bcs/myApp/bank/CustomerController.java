package ee.bcs.myApp.bank;

import ee.bcs.myApp.MyAppApplication;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;


    @PostMapping()
    @Operation(summary = "Lisab uue kliendi.")
    public Integer addNewCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addNewCustomer(customerDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik kliendid")
    public List<Customer> getAllCustomers() {
        return MyAppApplication.bankRepository.getCustomers();
    }

    @GetMapping("/id")
    @Operation(summary = "Otsib kasutaja id järgi")
    public Customer findCustomerById(@RequestParam Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }
        return result;
    }

    @DeleteMapping("/id")
    public void removeCustomerById(@RequestParam Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }
        customers.remove(result);
    }


}
