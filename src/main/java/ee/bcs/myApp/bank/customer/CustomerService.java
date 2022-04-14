package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


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
//
//    private List<CustomerDto> toDto(List<Customer> customers) {
//        List<CustomerDto> customerDtos = new ArrayList<>();
//
//        for (Customer customer : customers) {
//            CustomerDto customerDto = toDto(customer);
//            customerDtos.add(customerDto);
//        }
//        return customerDtos;
//    }
//
//
//    private Customer findCustomerById(Integer id, List<Customer> customers) {
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
}
