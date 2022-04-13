package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerRepository customerRepository;

    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);

        return customerMapper.toDto(customer);
    }

    public List<CustomerDto> getAllCustomers() { //kui me kutsume meetodi välja, on vaja luua ka objekt, vaata järgmine rida
        List<Customer> allCustomers = customerRepository.findAll();
        return customerMapper.toDtos(allCustomers);
    }

    public CustomerDto findCustomerById(Integer id) {
        // TODO: kontrolli kas customer on olemas, kui ei, pane veateade!
        Customer customer = customerRepository.getById(id); //get ootame, et tuleb ka vastus, findiga ei pruugi midagi tagasi tulla
        return customerMapper.toDto(customer);
    }

    public void removeCustomerById(Integer id) {
        // TODO: kontrolli kas customer on olemas, kui ei, pane veateade!
        customerRepository.deleteById(id);
    }

    public void updateCustomerById(Integer customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.getById(customerId);
        customerMapper.updateEntity(customerDto, customer);
        customerRepository.save(customer);
    }
}
