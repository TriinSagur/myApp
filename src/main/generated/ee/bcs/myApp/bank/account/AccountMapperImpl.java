package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-14T07:37:22+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntity(AccountDto accountDto1) {
        if ( accountDto1 == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDto1.getId() );
        account.setAccountNumber( accountDto1.getAccountNumber() );
        account.setBalance( accountDto1.getBalance() );
        account.setLocked( accountDto1.getLocked() );

        return account;
    }

    @Override
    public AccountResponse toResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setCustomerId( accountCustomerId( account ) );
        accountResponse.setFirstName( accountCustomerFirstName( account ) );
        accountResponse.setLastName( accountCustomerLastName( account ) );
        accountResponse.setIsikukood( accountCustomerIsikukood( account ) );
        accountResponse.setAccountNumber( account.getAccountNumber() );
        accountResponse.setBalance( account.getBalance() );
        accountResponse.setLocked( account.getLocked() );

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
