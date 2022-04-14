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

    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return customerMapper.toDtos(allCustomers);
    }

    public CustomerDto findCustomerById(Integer id) {
        // TODO: 13.04.2022   kui pole olemas, veahaldus
        Customer customer = customerRepository.getById(id);
        return customerMapper.toDto(customer);
    }

    public void removeCustomerById(Integer id) {
        // TODO: 13.04.2022   kui pole olemas, veahaldus
        customerRepository.deleteById(id);
    }

    public void updateCustomerById(Integer customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.getById(customerId);
        customerMapper.updateEntity(customerDto, customer);
        customerRepository.save(customer);
    }


//    private Customer findCustomerEntityById(Integer id) {
//        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
//        Customer result = new Customer();
//        for (Customer customer : customers) {
//            if (customer.getId().equals(id)) {
//                result = customer;
//            }
//        }
//        return result;
//    }
}
