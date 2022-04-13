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

    @Resource
    private CustomerEntityRepository repository;


    @PostMapping("/add")
    @Operation(summary = "Lisab uue kliendi")
    public CustomerDto addNewCustomer(@Valid @RequestBody CustomerDto customerDto) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setIsikukood(customerDto.getIsikukood());

        repository.save(customerEntity);

        customerDto.setId(customerEntity.getId());

        return customerDto;
    }
    @GetMapping
    @Operation(summary = "/tagastab kõik kliendid")
    public List<CustomerDto> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    // tagastab kliendi id järgi, enne, kui kustutad või teed sellega midagi
    //get eeldab, et seal on vastus, findiga võib juhtuda, et vastus on null

    @GetMapping("/id")
    @Operation(summary = "/Leiab andmebaasi ID järgi kliendi")
    public  CustomerDto findCustomerById(@RequestParam Integer id) {

        return customerService.findCustomerById(id);
    }

    @DeleteMapping("/id")
    @Operation(summary= "/Kustutab andmebaasi id järgi kliendi")
    public void removeCustomerId(@RequestParam Integer id) { //1.
        customerService.removeCustomerById(id);
    }
    @PutMapping
    @Operation(summary= "/Uuendab andmebaasi id järgi klienti")
    public void updateCustomerById(@RequestParam Integer id,@Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomerById(id, customerDto);
    }
}
