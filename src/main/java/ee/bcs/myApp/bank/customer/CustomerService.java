package ee.bcs.myApp.bank.customer;

import ee.bcs.myApp.MyAppApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    public CustomerDto addNewCustomer(CustomerDto customerDto) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer customer = toEntity(customerDto);

        customer.updateId();
        customers.add(customer);

        return toDto(customer);
    }


    public List<CustomerDto> findAllCustomers() {

        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        return toDto(customers);
    }

    public CustomerDto findCustomerById(Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer customer = findCustomerById(id, customers);
        return toDto(customer);
    }


    public CustomerDto removeCustomerById(@RequestParam Integer id) {
        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer customer = findCustomerById(id, customers);
        customers.remove(id);

        return toDto(customer);
    }

    public void updateCustomerById(Integer id, CustomerDto customerDto) {

        List<Customer> customers = MyAppApplication.bankRepository.getCustomers();
        Customer customer = findCustomerById(id, customers);

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setIsikukood(customerDto.getIsikukood());
    }

    private List<CustomerDto> toDto(List<Customer> customers) {
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDto customerDto = toDto(customer);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    private CustomerDto toDto(Customer customer) {
        CustomerDto customerDto;
        customerDto = new CustomerDto();
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

    private Customer findCustomerById(Integer id, List<Customer> customers) {

        Customer result = new Customer();

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                result = customer;
            }
        }
        return result;
    }
}
