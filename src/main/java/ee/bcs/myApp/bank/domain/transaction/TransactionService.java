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

    @Resource
    private AccountService accountService;

    @Resource
    private ValidationService validationService;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private TransactionRepository transactionRepository;


    public Transaction addDepositTransaction(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.getValidAccountById(request.getAccountId());
        Integer newBalance = calculateCreditBalance(account.getBalance(), request.getAmount());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }

    public Transaction addWithdrawTransaction(WithdrawRequest request) {
        Transaction transaction = transactionMapper.toWithdrawEntity(request);
        Account account = accountService.getValidAccountById(request.getAccountId());
        validationService.isWithinBalance(account.getBalance(), request.getAmount());
        Integer newBalance = calculateDebitBalance(account.getBalance(), request.getAmount());
        transaction.setSenderAccountNumber(account.getAccountNumber());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }


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
        return balance + amount;
    }

    private Integer calculateDebitBalance(Integer balance, Integer amount) {
        return balance - amount;
    }


    private void saveBankTransaction(Transaction transaction, Integer newBalance, Account account) {
        transaction.setBalance(newBalance);
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }
}
