package ee.bcs.myApp.bank.domain.customer;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private CustomerService customerService;

    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return customerMapper.toDto(allCustomers);
    }

    public CustomerDto findCustomerById(Integer id) {
        Customer customer = customerRepository.getById(id);
        return customerMapper.toDto(customer);
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
