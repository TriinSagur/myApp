package ee.bcs.myApp.bank.customer;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        List<Customer> customers = customerRepository.findAll();
        return  customerMapper.toDtos(customers);
    }

    public CustomerDto findCustomerById(Integer id) {
        Customer customer = customerRepository.getById(id);
        return customerMapper.toDto(customer);
    }



    public void removeCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }


    public void updateCustomerById(Integer id, CustomerDto customerDto) {
        Customer byId = customerRepository.getById(id);
        customerMapper.updateEntity(customerDto, byId);
        customerRepository.save(byId);

    }
}
