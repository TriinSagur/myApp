package ee.bcs.myApp.bank;

import ee.bcs.myApp.MyAppApplication;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CustomerService {

    public Integer addNewCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setIsikukood(customer.getIsikukood());
        customer.updateId();

        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        customers.add(customer);

        return customer.getId();
    }

    public List<Customer> getAllCustomers() {
        return MyAppApplication.bankRepository.getCustomers();
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

    List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

    public void removeCustomerById(@RequestParam Integer id) {
        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }

        customers.remove(result);
    }

    public void updateCustomerById(Integer id, CustomerDto customerDto) {
        Customer customer = findCustomerById(id);
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

    }
}
