package ee.bcs.myApp.bank;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    public Integer addNewCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());
        customer.updateId();
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        customers.add(customer);

        return customer.getId();
    }
}
