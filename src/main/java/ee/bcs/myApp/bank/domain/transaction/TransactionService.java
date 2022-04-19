package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountRepository;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.ReceiveMoneyRequest;
import ee.bcs.myApp.bank.service.ReceiveMoneyResponse;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class TransactionService {

    @Resource
    private AccountService accountService;

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private TransactionRepository transactionRepository;


    public Transaction addDepositTransaction(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    public Transaction addWithdrawTransaction(WithdrawRequest request) {
        Transaction transaction = transactionMapper.toWithdrawEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setSenderAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() - request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);

    }

    public void addReceiveMoneyTransaction(ReceiveMoneyRequest request) {
        Transaction transaction = transactionMapper.toReceiveMoneyEntity(request);
        Account account = accountService.findAccountByAccountNumber(request.getRecieverAccountNumber());
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);

        return transaction;
    }

    public ReceiveMoneyResponse receiveMoney(ReceiveMoneyRequest request);
}
