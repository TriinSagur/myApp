package ee.bcs.myApp.bank.domain.account;

import org.mapstruct.*;

import java.util.List;
// Selle annotatsiooniga võetakse siin klassis kasutusele MapStruct tehnoloogia,
// mis genereerib meile annotatsioonide kaasabil automaatselt ise ära vajalikud andmete kaardistamised/mäppimised,

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {


    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
    // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
    // https://youtu.be/BrSMvqcGMio
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName", source = "customer.lastName")
    @Mapping(target = "isikukood", source = "customer.isikukood")
    AccountResponse toResponse(Account account);

    List<AccountResponse> toResponses(List<Account> account);

    @Mapping(target = "id", ignore = true)
    Account toEntity(AccountDto dto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(AccountDto accountDto, @MappingTarget Account account);


}
