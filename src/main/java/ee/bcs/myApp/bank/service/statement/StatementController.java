package ee.bcs.myApp.bank.service.statement;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/statement")
@RestController
public class StatementController {

    @Resource
    private StatementService statementService;

    @GetMapping("/account-id")
    @Operation (summary = "Leiab konto väljavõtte konto ID järgi")
    public StatementResponse getStatementByAccountId(@RequestParam Integer accountId) {
        return statementService.getStatementByAccountId(accountId);
    }

}
