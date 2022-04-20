package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.MoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class TransactionService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private AccountService accountService;

    @Resource
    private ValidationService validationService;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private TransactionRepository transactionRepository;

    // See meetod on defineeritud nii, et ta võtab sisse DepositRequest tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama Transaction tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public Transaction addDepositTransaction(DepositRequest request) {

        // Kutsume paremal pool = märki välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        Transaction transaction = transactionMapper.toDepositEntity(request);

        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Account account = accountService.getValidAccountById(request.getAccountId());

        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Integer newBalance = calculateCreditBalance(account.getBalance(), request.getAmount());

        // Setteriga väärtustakse objekti välja väärtus
        transaction.setReceiverAccountNumber(account.getAccountNumber());

        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Vaata ka selle väljakutsutava meetodi kommentaare
        saveBankTransaction(transaction, newBalance, account);

        // Tagastame RETURN statement'iga 'transaction' objekti
        // Peale return'i minnakse sellest addDepositTransaction addDepositTransaction() meetodist välja
        return transaction;
    }

    // suht sarnane addDepositTransaction() meetodile
    // pole mõttet uuesti kirjeldada
    public Transaction addWithdrawTransaction(WithdrawRequest request) {
        Transaction transaction = transactionMapper.toWithdrawEntity(request);
        Account account = accountService.getValidAccountById(request.getAccountId());
        validationService.isWithinBalance(account.getBalance(), request.getAmount());
        Integer newBalance = calculateDebitBalance(account.getBalance(), request.getAmount());
        transaction.setSenderAccountNumber(account.getAccountNumber());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }

    // suht sarnane addDepositTransaction() meetodile
    // pole mõttet uuesti kirjeldada
    public Transaction addReceiveMoneyTransaction(MoneyRequest request) {
        Transaction transaction = transactionMapper.toReceiveMoneyEntity(request);
        Account account = accountService.getValidAccountByAccountNumber(request.getReceiverAccountNumber());
        Integer newBalance = calculateCreditBalance(account.getBalance(), request.getAmount());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }

    public Transaction addSendMoneyTransaction(MoneyRequest request) {
        Transaction senderTransaction = transactionMapper.toSendMoneyEntity(request);

        // todo: SENDER TRANSACTION
        Account senderAccount = accountService.getValidAccountByAccountNumber(request.getSenderAccountNumber());
        Integer senderBalance = senderAccount.getBalance();
        Integer amount = request.getAmount();
        validationService.isWithinBalance(senderBalance, amount);
        Integer senderNewBalance = calculateDebitBalance(senderBalance, amount);
        saveBankTransaction(senderTransaction, senderNewBalance, senderAccount);
        accountService.updateDebitPaymentBalance(senderAccount, amount);

        // todo: RECEIVER TRANSACTION
        if (accountService.accountExistsByAccountNumber(request.getReceiverAccountNumber())) {
            Transaction receiverTransaction = addReceiveMoneyTransaction(request);
            accountService.updateCreditPaymentBalance(receiverTransaction.getAccount(), amount);
        }

        return senderTransaction;
    }


    private Integer calculateCreditBalance(Integer balance, Integer amount) {
        // Siin vaatleme kõigepealt "return'i" paremat poolt.
        // Teeme kõigepealt ühe arvutuse
        // Tagastame RETURN statement'iga 'calculateCreditBalance()' tulemuse
        // Peale return'i minnakse sellest defineeritud addNewCustomer() meetodist välja
        return balance + amount;
    }

    private Integer calculateDebitBalance(Integer balance, Integer amount) {
        // Siin vaatleme kõigepealt "return'i" paremat poolt.
        // Teeme kõigepealt ühe arvutuse
        // Tagastame RETURN statement'iga 'calculateCreditBalance()' tulemuse
        // Peale return'i minnakse sellest defineeritud addNewCustomer() meetodist välja
        return balance - amount;
    }


    private void saveBankTransaction(Transaction transaction, Integer newBalance, Account account) {

        // Setteritega väärtustakse objekti väljade väärtused
        transaction.setBalance(newBalance);
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);

        // Siin kasutame transactionRepository (värav) objekti, et saada ligi tabeli 'transaction' andmetele
        // see meetod save() on juba JpaRepository klassis endal olemas.
        // Seda meetodit save() me ei ole ise kuidagi loonud.
        // Kaasa anname vastava tabeli entity objekti, mis siis salvestatakse ka ühe reana andmebaasi tabelisse maha.
        // Tähtis on ka teada, et peale save() meetodist läbi käimist, uundatakse ka selle objekti välja 'id' väärtust
        // mis saadakse adnmebaasi tabelist (järgmine vaba id, primary key veerus)
        transactionRepository.save(transaction);
    }
}
