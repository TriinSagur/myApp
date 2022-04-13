package ee.bcs.myApp.bank.customer;

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
    // ligipääs repositooriumile, mille kaudu saame andmebasile ligi

    @PostMapping
    @Operation(summary = "lisab uue kliendi")
    public CustomerDto addNewCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.addNewCustomer((customerDto));
    }

    @GetMapping("/all")
    @Operation(summary = "tagastab kõik kliendid")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
//
//    @GetMapping("/id")
//    @Operation (summary = "leiab andmebaasi ID järgi kliendikoodi")
//    public CustomerDto findCustomerById(@RequestParam Integer id) {
//        return customerService.findCustomerById(id);
//    }
//
//    @DeleteMapping("/id")
//    @Operation (summary = "kustutab andmebaasi ID järgi kliendikoodi")
//    public void removeCustomerId(@RequestParam Integer id) {
//        customerService.removeCustomerById(id);
//    }
//
//    @PutMapping("/id")
//    @Operation (summary = "uuendab andmebaasi id järgi klienti.")
//    public void updateCustomerById(@RequestParam Integer id, @Valid @RequestBody CustomerDto customerDto) {
//        customerService.updateCustomerById(id, customerDto);
//    }
//
//}
