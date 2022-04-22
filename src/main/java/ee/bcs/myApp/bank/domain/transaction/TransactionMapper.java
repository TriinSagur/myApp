package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import ee.bcs.myApp.bank.service.statement.Statement;
import ee.bcs.myApp.bank.service.transfer.TransferRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

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
