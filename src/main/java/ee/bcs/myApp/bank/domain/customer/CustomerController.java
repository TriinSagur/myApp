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
    @Operation(summary = "lisab uue kliendi")
    public CustomerDto addNewCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.addNewCustomer(customerDto);
    }

    @GetMapping("/all")
    @Operation(summary = "tagastab kõik kliendid")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/id")
    @Operation(summary = "leiame andmebaasi ID järgi kliendi")
    public CustomerDto findCustomerById(@RequestParam Integer id) {
        return customerService.findCustomerDtoById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary =  "kustutab andmebaasi id järgi kliendi")
    public void removeCustomerById(@RequestParam Integer id) {
        customerService.removeCustomerById(id);
    }

    @PutMapping("/id")
    @Operation(summary = "uuendab andmebaasi id järgi klienti")
    public void updateCustomerById(@RequestParam Integer id, @Valid @RequestBody CustomerDto customerDto) {  // @ Valid et arvestaks ka not null ja size, lisada request body ette
        customerService.updateCustomerById(id, customerDto);

    }
}
