package ee.bcs.myApp.validation;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.infrastructure.exception.BusinessExeption;
import ee.bcs.myApp.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {

    public static final String ACCOUNT_NOT_EXIST = "Kontot ei eksisteeri.";
    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit on ületatud";
    public static final String WITHDRAW_OVER_LIMIT = "Raha väljavõtmise limiit on ületatud";
    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid";


    public void accountExists(Integer accountId, Optional<Account> account) {
        if (account.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXIST, "Kontot ID-ga" + accountId + " ei leitud.");
        }
    }

    public void accountExists(String accountNumber, Optional<Account> account) {
        if (account.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXIST, "Kontot kontonumbriga" + accountNumber + " ei leitud.");
        }
    }

    public void isValidDepositAmount(Integer amount) {
        Integer limit = 5000;
        if (amount > limit) {
            throw new BusinessExeption(DEPOSIT_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
        }
    }

    public void isValidWithdrawAmount(Integer amount) {
        Integer limit = 15000;
        if (amount > limit) {
            throw new BusinessExeption(WITHDRAW_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
        }
    }

    public void isWithinBalance(Integer balance, Integer amount) {
        if (amount < balance) {
            throw new BusinessExeption(INSUFFICIENT_FUNDS, "Summa €" + amount + " ületab kontojääki €" + balance);
        }
    }
}
