package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.transfer.TransferRequest;
import ee.bcs.myApp.bank.service.transfer.DepositRequest;
import ee.bcs.myApp.bank.service.transfer.WithdrawRequest;
import ee.bcs.myApp.bank.service.statement.Statement;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "senderAccountNumber", constant = "ATM")
    @Mapping(target = "type", constant = "d")
    Transaction toDepositEntity(DepositRequest request);

    @Mapping(target = "receiverAccountNumber", constant = "ATM")
    @Mapping(target = "type", constant = "w")
    Transaction toWithdrawEntity(WithdrawRequest request);

    @Mapping(target = "type", constant = "r")
    Transaction toReceiveMoneyEntity(TransferRequest request);

    @Mapping(target = "type", constant = "s")
    Transaction toSendMoneyEntity(TransferRequest request);

    List<Statement> toStatements(List<Transaction> transactions);

}
