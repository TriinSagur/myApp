package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

//
//    public List<CustomerDto> getAllCustomers() {
//        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
//
//        List<CustomerDto> customerDtos = new ArrayList<>();
//
//        for (Customer customer : customers) {
//            CustomerDto customerDto = toDto(customer);
//            customerDtos.add(customerDto);
//        }
//
//        return customerDtos;
//    }
//
//    public CustomerDto findCustomerDtoById(Integer id) {
//        Customer result = findCustomerEntityById(id);
//
//        return toDto(result);
//    }
//
//    private Customer findCustomerEntityById(Integer id) {
//        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
//
//        Customer result = new Customer();
//
//        for (Customer customer : customers) {
//            if (customer.getId().equals(id)) {
//                result = customer;
//            }
//        }
//        return result;
//    }
//
//
//    public void removeCustomerById(Integer id) {
//        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
//
//        Customer result = new Customer();
//        for (Customer customer : customers) {
//            if (customer.getId().equals(id)) {
//                result = customer;
//            }
//        }
//        customers.remove(result);
//    }
//
//    public void updateCustomerById(Integer id, CustomerDto customerDto) {
//        CustomerDto customer = findCustomerDtoById(id);
//        customer.setFirstName(customerDto.getFirstName());
//        customer.setLastName(customerDto.getLastName());
//    }
}
