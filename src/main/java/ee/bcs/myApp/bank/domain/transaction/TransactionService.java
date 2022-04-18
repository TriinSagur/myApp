package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.MoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class TransactionService {

    @Resource
    private TransactionRepository transactionRepository;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private AccountService accountService;


    public Transaction addDepositTransaction(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        Integer newBalance = calculateCreditBalance(account.getBalance(), request.getAmount());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }

    public Transaction addWithdrawTransaction(WithdrawRequest request) {
        Transaction transaction = transactionMapper.toWithdrawEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        Integer newBalance = calculateDebitBalance(account.getBalance(), request.getAmount());
        transaction.setSenderAccountNumber(account.getAccountNumber());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }

    public Transaction addReceiveMoneyTransaction(MoneyRequest request) {
        Transaction transaction = transactionMapper.toReceiveMoneyEntity(request);
        Account account = accountService.findAccountByAccountNumber(request.getReceiverAccountNumber());
        Integer newBalance = calculateCreditBalance(account.getBalance(), request.getAmount());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }

    public Transaction addSendMoneyTransaction(MoneyRequest request) {
        Transaction senderTransaction = transactionMapper.toSendMoneyEntity(request);
        //SENDER TRANSACTION
        Account senderAccount = accountService.findAccountByAccountNumber(request.getSenderAccountNumber());
        Integer senderNewBalance = calculateDebitBalance(senderAccount.getBalance(), request.getAmount());
        saveBankTransaction(senderTransaction, senderNewBalance, senderAccount);
        accountService.updateCreditPaymentBalance(senderAccount, request.getAmount());

        if (accountService.accountExistsByAccountNumber(request.getReceiverAccountNumber())) {
            //RECEIVER TRANSACTION
            Transaction receiverTransaction = addReceiveMoneyTransaction(request);
            accountService.updateCreditPaymentBalance(receiverTransaction.getAccount(), request.getAmount());

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
