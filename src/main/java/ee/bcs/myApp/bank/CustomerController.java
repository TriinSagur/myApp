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

       List<Customer> customers = bankRepository.getCustomers();
        customers.add(customer);


        return customer.getId();
    }
    @GetMapping("/all")
    @Operation(summary = "/tagastab kõik kliendid")
    public List<Customer> getAllCustomers() {

        return bankRepository.getCustomers();
    }

    // tagastab kliendi id järgi, enne, kui kustutad või teed sellega midagi
    //get eeldab, et seal on vastus, findiga võib juhtuda, et vastus on null

    @GetMapping("/find")
    @Operation(summary = "/Leiab andmebaasi ID järgi kliendi")
    public  Customer findCustomerById(@RequestParam Integer id) {
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
    @Operation(summary= "/kustutab kliendi")
    public void removeCustomerId(@RequestParam Integer id) { //1.
        List<Customer> customers = bankRepository.getCustomers();  //2.

        Customer result = new Customer();  //3.
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }
        customers.remove(result);
    }
}
