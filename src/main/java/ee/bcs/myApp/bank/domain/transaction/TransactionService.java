package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.DepositRequest;
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


    public void addDepositTransaction(DepositRequest request) {
        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() + request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);

    }

    public void addWithdrawTransaction(WithdrawRequest request) {
        Transaction transaction = transactionMapper.toWithdrawEntity(request);
        Account account = accountService.findAccountById(request.getAccountId());
        transaction.setSenderAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance() - request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }
}
