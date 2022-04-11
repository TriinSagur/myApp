package ee.bcs.myApp.bank;

import ee.bcs.myApp.MyAppApplication;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Service;

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

}
