package ee.bcs.myApp.validation;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.infrastructure.exception.BusinessException;
import ee.bcs.myApp.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {


    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri.";
    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit ületatud";
    public static final String WITHDRAW_OVER_LIMIT = "Raha välja võtmise limiit ületatud";
    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt raha tehingu sooritamiseks";

    public void accountExists(Integer accountId, Optional<Account> account) {
        if (account.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot ID´ga " + accountId + " ei leitud.");
        }
    }

    public void accountExists(String accountNumber, Optional<Account> account) {
        if (account.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot kontonumbriga " + accountNumber + " ei leitud.");
        }
    }

    public void isValidDepositAmount(Integer amount) {

        Integer limit = 5000;
        if (amount > limit) {
            throw new BusinessException(DEPOSIT_OVER_LIMIT, "Summa " + amount  + " on suurem, kui limiit: " + limit);
        }
    }

    public void isValidWithdrawAmount(Integer amount) {

        Integer limit = 15000;
        if (amount >= limit) {
            throw new BusinessException(WITHDRAW_OVER_LIMIT, "Väljavõetav summa " + amount  + " ületab " + limit + "limiiti");
        }
    }

    public void isWithinBalance(Integer balance, Integer amount) {
        if (amount > balance) {
            throw new BusinessException(INSUFFICIENT_FUNDS, "Summa " + amount + " ületab kontojääki " + balance);
        }
    }
}
