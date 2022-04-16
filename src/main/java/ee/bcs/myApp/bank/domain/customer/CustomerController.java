package ee.bcs.myApp.bank.domain.customer;


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

    @PostMapping
    @Operation(summary = "Lisab uue kliendi.")
    public CustomerDto addNewCustomer(@RequestBody CustomerDto customerDto) {

        return customerService.addNewCustomer(customerDto);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab kliendilisti.")
    public List<CustomerDto> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/id")
    @Operation(summary = "Leiab ID järgi kliendi")
    public CustomerDto findCustomerById(@RequestParam Integer id) {

        return customerService.findCustomerById(id);

    }

    @DeleteMapping("/id")
    @Operation(summary = "Kustutab ID järgi kliendi")
    public void removeCustomerById(@RequestParam Integer id) {
        customerService.removeCustomerById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "Uuendab andmebaasi id järgi klienti.")
    public void updateCustomerById(@RequestParam Integer id, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomerById(id, customerDto);

    }
}


