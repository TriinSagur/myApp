package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;

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
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDto customerDto = toDto(customer);
            customerDtos.add(customerDto);
        }


        return customerDtos;
    }

    public CustomerDto findCustomerById(Integer id) {
        Customer result = findCustomerEntityById(id);

        return toDto(result);
    }

    private Customer findCustomerEntityById(Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }
        return result;
    }

    public void removeCustomerById(Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();

        Customer result = new Customer();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }

        customers.remove(result);
    }


    public void updateCustomerById(Integer id, CustomerDto customerDto) {
        Customer customer = findCustomerEntityById(id);
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
