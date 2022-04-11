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

    @PostMapping
    @Operation(summary = "lisab uue kliendi")
    public Integer addNewCustomer(@RequestBody CustomerDto customerDto) {

        return customerService.addNewCustomer(customerDto);

    }

    @GetMapping("/all")
    @Operation(summary = "tagastab koik kliendid")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/id")
    @Operation(summary = "leiab andmebaasi ID jargi kliendi")
    public Customer findCustomerById(@RequestParam Integer id) {

        return customerService.findCustomerById(id);
    }


    @DeleteMapping("/id")
    public void removeCustomerById(@RequestParam Integer id) {

        customerService.removeCustomerById(id);
    }
//    TODO: customeri lisami

}
