package ee.bcs.myApp.validation;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {


    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri.";

    public void accountExists(Integer accountId, Optional<Account> account) {
        if (account.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot ID´ga " + accountId + " ei leitud.");
        }
    }
}
