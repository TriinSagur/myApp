package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.service.DepositRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class TransactionService {


    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private TransactionRepository transactionRepository;

    public void addDepositTransaction(DepositRequest request) {

        Transaction transaction = transactionMapper.toDepositEntity(request);
        Account account = accountService.finAccountById(request.getAccountId());
        transaction.setReceiverAccountNumber(account.getAccountNumber());
        transaction.setBalance(account.getBalance()+request.getAmount());
        transaction.setTransactionDateTime(Instant.now());
        transaction.setAccount(account);
        transactionRepository.save(transaction);

    }

}
