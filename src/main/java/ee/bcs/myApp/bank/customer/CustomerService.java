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
        customerRepository.save(customer);                              // alles andmebaasi minnes saab ID

        return customerMapper.toDto(customer);
    }

//    public List<CustomerDto> getAllCustomers() {
//        List<Customer> customers = MyAppApplication.bankRepository.getCustomers(); // saime kõik kliendid customer listist
//
//        List<CustomerDto> customerDtos = new ArrayList<>();                     // teeme tühja Dto listi
//
//        for (Customer customer : customers) {                                   //käi kõik objektid customer listis läbi
//            CustomerDto customerDto = customerMapper.toDto(customer);
//            customerDtos.add(customerDto);
//        }
//        return customerDtos;
//    }
//
//    public CustomerDto findCustomerById(Integer id) {
//        Customer result = findCustomerEntityById(id);
//        return customerMapper.toDto(result);
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
//    public void removeCustomerById(Integer id) {
//        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
//        Customer result = new Customer();
//        for (Customer customer : customers) {
//            if (customer.getId().equals(id)) { // see id tuleb parameetrist(mida me küsime tagasi)
//                result = customer;
//            }
//        }
//        customers.remove(result);
//    }
//
//    public void updateCustomerById(Integer id, CustomerDto customerDto) {
//        Customer customer = findCustomerEntityById(id);
//        customer.setFirstName(customerDto.getFirstName());
//        customer.setLastName(customerDto.getLastName());
//        customer.setIsikukood(customerDto.getIsikukood());
//
//    }
}
