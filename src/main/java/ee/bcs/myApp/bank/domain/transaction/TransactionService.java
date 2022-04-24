package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.statement.Statement;
import ee.bcs.myApp.bank.service.transfer.DepositRequest;
import ee.bcs.myApp.bank.service.transfer.TransferRequest;
import ee.bcs.myApp.bank.service.transfer.WithdrawRequest;
import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

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


    public Transaction addReceiveMoneyTransaction(TransferRequest request) {
        Transaction transaction = transactionMapper.toReceiveMoneyEntity(request);
        Account account = accountService.getValidAccountByAccountNumber(request.getReceiverAccountNumber());
        Integer newBalance = calculateCreditBalance(account.getBalance(), request.getAmount());
        saveBankTransaction(transaction, newBalance, account);
        return transaction;
    }

    public Transaction addSendMoneyTransaction(TransferRequest request) {
        Transaction senderTransaction = transactionMapper.toSendMoneyEntity(request);

        Account senderAccount = accountService.getValidAccountByAccountNumber(request.getSenderAccountNumber());
        Integer senderBalance = senderAccount.getBalance();
        Integer amount = request.getAmount();

        validationService.isWithinBalance(senderBalance, amount);
        Integer senderNewBalance = calculateDebitBalance(senderBalance, amount);
        saveBankTransaction(senderTransaction, senderNewBalance, senderAccount);
        accountService.updateDebitPaymentBalance(senderAccount, amount);

        if (accountService.accountExistsByAccountNumber(request.getReceiverAccountNumber())) {
            Transaction receiveTransaction = addReceiveMoneyTransaction(request);//VASTUVÕTJA
            accountService.updateCreditPaymentBalance(receiveTransaction.getAccount(), amount);
        }
        return senderTransaction;
    }


    public  List<Statement> getStatementByAccountId(Integer accountId) {
        List<Transaction> transactions = transactionRepository.findTransactionsByAccountId(accountId);
       return transactionMapper.toStatements(transactions);

    }

    private Integer calculateCreditBalance(Integer balance, Integer amount) {
        return balance + amount;
    }

    private Integer calculateDebitBalance(Integer balance, Integer amount) {
        return balance - amount;
    }

    private void saveBankTransaction(Transaction transaction, int newBalance, Account account) {
        transaction.setBalance(newBalance);
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

}
