package ee.bcs.myApp.bank.service.statement;

import ee.bcs.myApp.bank.domain.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatementResponse {


    private List<Statement> statements;

}
