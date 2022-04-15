package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.customer.CustomerDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-15T14:31:18+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponse toResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        Integer customerId = null;
        String accountNumber = null;
        Integer balance = null;
        Boolean locked = null;

        customerId = accountCustomerId( account );
        accountNumber = account.getAccountNumber();
        balance = account.getBalance();
        locked = account.getLocked();

        AccountResponse accountResponse = new AccountResponse( customerId, accountNumber, balance, locked );

        accountResponse.setFirstName( accountCustomerFirstName( account ) );
        accountResponse.setLastName( accountCustomerLastName( account ) );
        accountResponse.setIsikukood( accountCustomerIsikukood( account ) );

        return accountResponse;
    }

    @Override
    public List<AccountResponse> toResponses(List<Account> account) {
        if ( account == null ) {
            return null;
        }

        List<AccountResponse> list = new ArrayList<AccountResponse>( account.size() );
        for ( Account account1 : account ) {
            list.add( toResponse( account1 ) );
        }

        return list;
    }

    @Override
    public void updateEntity(AccountDto accountDto, Account account) {
        if ( accountDto == null ) {
            return;
        }

        if ( accountDto.getCustomer() != null ) {
            if ( account.getCustomer() == null ) {
                account.setCustomer( new Customer() );
            }
            customerDtoToCustomer( accountDto.getCustomer(), account.getCustomer() );
        }
        if ( accountDto.getAccountNumber() != null ) {
            account.setAccountNumber( accountDto.getAccountNumber() );
        }
        if ( accountDto.getBalance() != null ) {
            account.setBalance( accountDto.getBalance() );
        }
        if ( accountDto.getLocked() != null ) {
            account.setLocked( accountDto.getLocked() );
        }
    }

    private Integer accountCustomerId(Account account) {
        if ( account == null ) {
            return null;
        }
        Customer customer = account.getCustomer();
        if ( customer == null ) {
            return null;
        }
        Integer id = customer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String accountCustomerFirstName(Account account) {
        if ( account == null ) {
            return null;
        }
        Customer customer = account.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String firstName = customer.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String accountCustomerLastName(Account account) {
        if ( account == null ) {
            return null;
        }
        Customer customer = account.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String lastName = customer.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String accountCustomerIsikukood(Account account) {
        if ( account == null ) {
            return null;
        }
        Customer customer = account.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String isikukood = customer.getIsikukood();
        if ( isikukood == null ) {
            return null;
        }
        return isikukood;
    }

    protected void customerDtoToCustomer(CustomerDto customerDto, Customer mappingTarget) {
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
