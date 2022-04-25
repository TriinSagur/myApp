package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-25T11:42:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponse toResponse(Account entity) {
        if ( entity == null ) {
            return null;
        }

        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setCustomerId( entityCustomerId( entity ) );
        accountResponse.setFirstName( entityCustomerFirstName( entity ) );
        accountResponse.setLastName( entityCustomerLastName( entity ) );
        accountResponse.setIsikukood( entityCustomerIsikukood( entity ) );
        accountResponse.setAccountId( entity.getId() );
        accountResponse.setAccountNumber( entity.getAccountNumber() );
        accountResponse.setBalance( entity.getBalance() );
        accountResponse.setLocked( entity.getLocked() );

        return accountResponse;
    }

    @Override
    public List<AccountResponse> toResponses(List<Account> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AccountResponse> list = new ArrayList<AccountResponse>( entities.size() );
        for ( Account account : entities ) {
            list.add( toResponse( account ) );
        }

        return list;
    }

    @Override
    public void updateEntity(AccountDto dto, Account entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getAccountNumber() != null ) {
            entity.setAccountNumber( dto.getAccountNumber() );
        }
        if ( dto.getBalance() != null ) {
            entity.setBalance( dto.getBalance() );
        }
        if ( dto.getLocked() != null ) {
            entity.setLocked( dto.getLocked() );
        }
    }

    private Integer entityCustomerId(Account account) {
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

    private String entityCustomerFirstName(Account account) {
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

    private String entityCustomerLastName(Account account) {
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

    private String entityCustomerIsikukood(Account account) {
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
