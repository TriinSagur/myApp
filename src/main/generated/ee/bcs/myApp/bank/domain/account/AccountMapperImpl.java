package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-14T11:56:25+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
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
    public List<AccountResponse> toResponses(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountResponse> list = new ArrayList<AccountResponse>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( toResponse( account ) );
        }

        return list;
    }

    @Override
    public void updateEntity(AccountDto accountDto1, Account account) {
        if ( accountDto1 == null ) {
            return;
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
}
