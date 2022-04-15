package ee.bcs.myApp.bank.domain.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


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


    public List<CustomerDto> findAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return customerMapper.toDtos(allCustomers);
    }

    public CustomerDto findCustomerById(Integer id) {
        Customer customer = customerRepository.getById(id);
        return customerMapper.toDto(customer);
    }


    public void removeCustomerById(@RequestParam Integer id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomerById(Integer id, CustomerDto customerDto) {
        Customer customer = customerRepository.getById(id);
        customerMapper.updateEntity(customerDto, customer);
        customerRepository.save(customer);
    }

}
