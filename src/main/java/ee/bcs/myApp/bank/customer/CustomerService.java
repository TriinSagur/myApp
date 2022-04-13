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

    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return customerMapper.doDtos(allCustomers);
    }

    public CustomerDto findCustomerById(Integer id) {
        Customer customer = customerRepository.getById(id);
        return customerMapper.toDto(customer);

//        Optional<Customer> optionalCustomer = customerRepository.findById(id);
//        Customer customer = optionalCustomer.get();
//        return         customerMapper.toDto(customer);

    }

    public void removeCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomerById(Integer customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.getById(customerId);
        customerMapper.updateEntity(customerDto, customer);
        customerRepository.save(customer);
    }

}
