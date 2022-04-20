package ee.bcs.myApp.bank.domain.transaction;

import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.MoneyRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import org.mapstruct.*;

// Selle annotatsiooniga võetakse siin klassis kasutusele MapStruct tehnoloogia,
// mis genereerib meile annotatsioonide kaasabil automaatselt ise ära vajalikud andmete kaardistamised/mäppimised,
// Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
// https://youtu.be/BrSMvqcGMio
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {
// vajuta IntelliJ-s ka implement noolekesele, mis viib sind klassi (TransactionMapperImpl),
// kus see interface klass on ära implementeeritud (ära lahendatud).
// See lahendus on siis MapStructi poolt genereeritud.


    // Mäpper (Dto -> Entity)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
    // @Mapping(target = "senderAccountNumber", constant = "ATM") - sellega defineerime mäpperi nii,
    // et target klassi 'senderAccountNumber' välja me väärtustame väärtusega "ATM"
    // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
    // https://youtu.be/BrSMvqcGMio
    @Mapping(target = "senderAccountNumber", constant = "ATM")
    @Mapping(target = "type", constant = "d")
    Transaction toDepositEntity(DepositRequest request);

    @Mapping(target = "receiverAccountNumber", constant = "ATM")
    @Mapping(target = "type", constant = "w")
    Transaction toWithdrawEntity(WithdrawRequest request);

    @Mapping(target = "type", constant = "r")
    Transaction toReceiveMoneyEntity(MoneyRequest request);

    @Mapping(target = "type", constant = "s")
    Transaction toSendMoneyEntity(MoneyRequest request);
}
