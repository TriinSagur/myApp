package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.customer.Customer;
import ee.bcs.myApp.bank.customer.CustomerDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-13T14:31:19+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntity(AccountDto1 accountDto1) {
        if ( accountDto1 == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDto1.getId() );
        account.setCustomer( customerDtoToCustomer( accountDto1.getCustomer() ) );
        account.setAccountNumber( accountDto1.getAccountNumber() );
        account.setBalance( accountDto1.getBalance() );
        account.setLocked( accountDto1.getLocked() );

        return account;
    }

    @Override
    public AccountDto1 toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        Integer id = null;
        CustomerDto customer = null;
        String accountNumber = null;
        Integer balance = null;
        Boolean locked = null;

        id = account.getId();
        customer = customerToCustomerDto( account.getCustomer() );
        accountNumber = account.getAccountNumber();
        balance = account.getBalance();
        locked = account.getLocked();

        AccountDto1 accountDto1 = new AccountDto1( id, customer, accountNumber, balance, locked );

        return accountDto1;
    }

    @Override
    public void updateEntity(AccountDto1 accountDto1, Account account) {
        if ( accountDto1 == null ) {
            return;
        }

        if ( accountDto1.getId() != null ) {
            account.setId( accountDto1.getId() );
        }
        if ( accountDto1.getCustomer() != null ) {
            if ( account.getCustomer() == null ) {
                account.setCustomer( new Customer() );
            }
            customerDtoToCustomer1( accountDto1.getCustomer(), account.getCustomer() );
        }
        if ( accountDto1.getAccountNumber() != null ) {
            account.setAccountNumber( accountDto1.getAccountNumber() );
        }
        if ( accountDto1.getBalance() != null ) {
            account.setBalance( accountDto1.getBalance() );
        }
        if ( accountDto1.getLocked() != null ) {
            account.setLocked( accountDto1.getLocked() );
        }
    }

    protected Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setFirstName( customerDto.getFirstName() );
        customer.setLastName( customerDto.getLastName() );
        customer.setIsikukood( customerDto.getIsikukood() );

        return customer;
    }

    protected CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setFirstName( customer.getFirstName() );
        customerDto.setLastName( customer.getLastName() );
        customerDto.setIsikukood( customer.getIsikukood() );

        return customerDto;
    }

    protected void customerDtoToCustomer1(CustomerDto customerDto, Customer mappingTarget) {
        if ( customerDto == null ) {
            return;
        }

        if ( customerDto.getId() != null ) {
            mappingTarget.setId( customerDto.getId() );
        }
        if ( customerDto.getFirstName() != null ) {
            mappingTarget.setFirstName( customerDto.getFirstName() );
        }
        if ( customerDto.getLastName() != null ) {
            mappingTarget.setLastName( customerDto.getLastName() );
        }
        if ( customerDto.getIsikukood() != null ) {
            mappingTarget.setIsikukood( customerDto.getIsikukood() );
        }
    }
}
