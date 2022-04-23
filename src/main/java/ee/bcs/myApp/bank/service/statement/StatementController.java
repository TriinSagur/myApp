package ee.bcs.myApp.bank.service.statement;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/statement")
public class StatementController {

    @Resource
    private StatementService statementService;

    @GetMapping("/account-id")
    @Operation(summary = "leiab kontoväljavõtte konto id järgi")
    public StatementResponse getStatementByAccountId(@RequestParam Integer accountId) {
        return statementService.getStatementByAccountId(accountId);
    }

}
