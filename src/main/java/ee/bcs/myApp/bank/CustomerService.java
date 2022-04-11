package ee.bcs.myApp.bank;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        Customer customer = toEntity(customerDto);
        customer.updateId();

        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        customers.add(customer);

        return toDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers(); // saime kõik kliendid customer listist

        List<CustomerDto> customerDtos = new ArrayList<>();                     // teeme tühja Dto listi

        for (Customer customer : customers) {                                   //käi kõik objektid customer listis läbi
            CustomerDto customerDto = toDto(customer);
            customerDtos.add(customerDto);

        }

        return customerDtos;
    }

    public Customer findCustomerById(@RequestParam Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

        Customer result = new Customer();

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }
        return result;
    }

    public void removeCustomerById(@RequestParam Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) { // see id tuleb parameetrist(mida me küsime tagasi)
                result = customer;
            }
        }
        customers.remove(result);
    }

    public void updateCustomerById(Integer id, CustomerDto customerDto) {
        Customer customer = findCustomerById(id);
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());

    }

    private CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setIsikukood(customer.getIsikukood());
        return customerDto;
    }

    private Customer toEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());
        return customer;
    }
}
