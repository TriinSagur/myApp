package ee.bcs.myApp.validation;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.infrastructure.exception.BusinessException;
import ee.bcs.myApp.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {

    // Siin klassis tegeleme vea olukordade valideerimisega, et vajadusel visata ülesse mingi viga.

    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri";
    public static final String CUSTOMER_NOT_EXISTS = "Sellist klienti ei eksisteeri";
    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit on ületatud";
    public static final String WITHDRAW_OVER_LIMIT = "Raha väljavõtmise limiit on ületatud";
    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid tehingu sooritamiseks";

    // See meetod on defineeritud nii, et ta võtab sisse Integer ja Optional<Account>  tüüp objektid
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi. Siin meetodis puudub RETURN statement.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void accountExists(Integer accountId, Optional<Account> account) {

        // Siin kontrollime, Optional klassis oleva meetodiga isEmpty(), et kas meil on seal sees 'null'
        if (account.isEmpty()) {

            // Kui on 'null', ehk tühi, siis visatakse 'throw new" abil ülesse viga.
            // Konstruktoris antakse kaasa vea teate jaoks mingid andmed (title ja detail)
            // Klassis RestExceptionHandler püütakse kinni teatud vead
            // (kaasa arvatud ka see DataNotFoundException tüüpi viga).
            // Vaata ka selle klassi kommentaare.
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot ID'ga " + accountId + " ei leitud");
        }
    }

    // See meetod on defineeritud nii, et ta võtab sisse String ja Optional<Account> tüüpi objektid
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi. Siin meetodis puudub RETURN statement.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void accountExists(String accountNumber, Optional<Account> account) {

        // Siin kontrollime, Optional klassis oleva meetodiga isEmpty(), et kas meil on seal sees 'null'
        if (account.isEmpty()) {

            // Kui on 'null', ehk tühi, siis visatakse 'throw new" abil ülesse viga.
            // Konstruktoris antakse kaasa vea teate jaoks mingid andmed (title ja detail)
            // Klassis RestExceptionHandler püütakse kinni teatud vead
            // (kaasa arvatud ka see DataNotFoundException tüüpi viga).
            // Vaata ka selle klassi kommentaare.
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot kontonumbriga " + accountNumber + " ei leitud");
        }
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüpi objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi. Siin meetodis puudub RETURN statement.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void isValidDepositAmount(Integer amount) {


        // productionsis tuleks see väärtus andmebaasist
        Integer limit = 5000;

        // Siin kontrollime, et kas soovitud deposiidi summa ületab lubatud limiiti.
        if (amount > limit) {

            // Kui ületab lubatud limiitt, siis visatakse 'throw new" abil ülesse viga.
            // Konstruktoris antakse kaasa vea teate jaoks mingid andmed (title ja detail)
            // Klassis RestExceptionHandler püütakse kinni teatud vead
            // (kaasa arvatud ka see BusinessException tüüpi viga).
            // Vaata ka selle klassi kommentaare.
            throw new BusinessException(DEPOSIT_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
        }
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüpi objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi. Siin meetodis puudub RETURN statement.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void isValidWithdrawAmount(Integer amount) {

        // productionsis tuleks see väärtus andmebaasist
        Integer limit = 15000;

        // Siin kontrollime, et kas soovitud väljavõetava raha summa ületab lubatud limiiti.
        if (amount > limit) {

            // Kui ületab lubatud limiitt, siis visatakse 'throw new" abil ülesse viga.
            // Konstruktoris antakse kaasa vea teate jaoks mingid andmed (title ja detail)
            // Klassis RestExceptionHandler püütakse kinni teatud vead
            // (kaasa arvatud ka see BusinessException tüüpi viga).
            // Vaata ka selle klassi kommentaare.
            throw new BusinessException(WITHDRAW_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
        }
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer ja Integer tüüpi objektid
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi. Siin meetodis puudub RETURN statement.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void isWithinBalance(Integer balance, Integer amount) {

        // Siin kontrollime, et kas soovitud summa ületab hetke kontojääki.
        if (amount > balance) {

            // Kui ületab jääki, siis visatakse 'throw new" abil ülesse viga.
            // Konstruktoris antakse kaasa vea teate jaoks mingid andmed (title ja detail)
            // Klassis RestExceptionHandler püütakse kinni teatud vead
            // (kaasa arvatud ka see BusinessException tüüpi viga).
            // Vaata ka selle klassi kommentaare.
            throw new BusinessException(INSUFFICIENT_FUNDS, "Summa €" + amount + " ületab kontojääki €" + balance);
        }
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer ja Optional<Account>  tüüp objektid
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi. Siin meetodis puudub RETURN statement.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void customerExists(Integer customerId, Optional<Customer> customer) {

        // Siin kontrollime, Optional klassis oleva meetodiga isEmpty(), et kas meil on seal sees 'null'
        if (customer.isEmpty()) {

            // Kui on 'null', ehk tühi, siis visatakse 'throw new" abil ülesse viga.
            // Konstruktoris antakse kaasa vea teate jaoks mingid andmed (title ja detail)
            // Klassis RestExceptionHandler püütakse kinni teatud vead
            // (kaasa arvatud ka see DataNotFoundException tüüpi viga).
            // Vaata ka selle klassi kommentaare.
            throw new DataNotFoundException(CUSTOMER_NOT_EXISTS, "Klienti ID'ga " + customerId + " ei leitud");
        }
    }
}
