package ee.bcs.myApp.bank.domain.customer;

import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private ValidationService validationService;

    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        boolean customerExists = customerRepository.existsByIsikukood(customerDto.getIsikukood());
        validationService.isikukoodAlreadyExists(customerDto.getIsikukood(), customerExists);
        customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return customerMapper.toDtos(allCustomers);
    }

    public CustomerDto findCustomerById(Integer id) {
        Customer customer = getValidCustomerById(id);
        return customerMapper.toDto(customer);
    }

    public void removeCustomerById(Integer customerId) {
        Customer customer = getValidCustomerById(customerId);
        customerRepository.deleteById(customer.getId());
    }


    public void updateCustomerById(Integer customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.getById(customerId);
        customerMapper.updateEntity(customerDto, customer);
        customerRepository.save(customer);
    }

    private Customer getValidCustomerById(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        validationService.customerExists(customerId, customer);
        return customer.get();
    }

}
