package ee.bcs.myApp.bank;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    public static Bank bankRepository = new Bank();

    @PostMapping("/add")
    @Operation(summary = "Lisab uue kliendi.")
    public Integer addNewCustomer(@RequestBody CustomerDto customerDto) {

        Customer someCustomer = new Customer();
        someCustomer.setFirstName(customerDto.getFirstName());
        someCustomer.setLastName(customerDto.getLastName());
        someCustomer.setIsikukood(customerDto.getIsikukood());
        someCustomer.increaseIdCounter();
        bankRepository.getCustomers().add(someCustomer);

        return someCustomer.getId();
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kliendilisti.")
    public List<Customer> getAllCustomers() {
        return bankRepository.getCustomers();
    }

    @GetMapping("/find-customer")
    @Operation(summary = "Leiab ID järgi kliendi")
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

    @DeleteMapping("/delete")
    @Operation(summary = "Kustutab ID järgi kliendi")
    public void removeCustomerById(@RequestParam Integer id) {
        List<Customer> customers = bankRepository.getCustomers();

        Customer result = new Customer();


        for (Customer customer1 : customers) {
            if (customer1.getId().equals(id)) {
                result = customer1;

            }

        }

        customers.remove(result);


    }


}


