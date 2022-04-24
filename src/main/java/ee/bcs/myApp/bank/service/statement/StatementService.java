package ee.bcs.myApp.bank.service.statement;

import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatementService {

    @Resource
    private TransactionService transactionService;

    public StatementResponse getStatementByAccountId(Integer accountId) {
        List<Statement> statements = transactionService.getStatementByAccountId(accountId);
        return new StatementResponse(statements);
    }
}
