package ee.bcs.myApp.bank;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Resource
    private CustomerService customerService;


    @PostMapping()
    @Operation(summary = "Lisab uue kliendi.")
    public CustomerDto addNewCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.addNewCustomer(customerDto);
    }


    @GetMapping("/all")
    @Operation(summary = "Tagastab kõik kliendid")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab andmebaasi ID järgi kliendi")
    public Customer findCostumerById(@RequestParam Integer id) {
        return customerService.findCostumerById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab kliendi andmebaasi ID järgi")
    public void removeCustomerById(@RequestParam Integer id) {
        customerService.removeCustomerById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab kliendi andmebaasi ID järgi")
    public void updateCustomerById(@RequestParam Integer id, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomerById(id, customerDto);
    }

}
