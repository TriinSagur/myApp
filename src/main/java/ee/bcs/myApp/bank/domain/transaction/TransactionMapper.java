package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.statement.Statement;
import ee.bcs.myApp.bank.service.statement.StatementResponse;
import ee.bcs.myApp.bank.service.transfer.DepositRequest;
import ee.bcs.myApp.bank.service.transfer.TransferRequest;
import ee.bcs.myApp.bank.service.transfer.WithdrawRequest;
import org.mapstruct.*;

import java.time.Instant;
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

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "senderAccountNumber", source = "")
//    @Mapping(target = "receiverAccountNumber", source = "")
//    @Mapping(target = "amount", source = "")
//    @Mapping(target = "balance", source = "")
//    @Mapping(target = "transactionDateTime", source = "")
    List<Statement> toStatements(List<Transaction> transactions);

}
