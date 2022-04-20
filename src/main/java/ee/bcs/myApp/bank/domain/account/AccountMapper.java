package ee.bcs.myApp.bank.domain.account;

import org.mapstruct.*;

import java.util.List;

// Selle annotatsiooniga võetakse siin klassis kasutusele MapStruct tehnoloogia,
// mis genereerib meile annotatsioonide kaasabil automaatselt ise ära vajalikud andmete kaardistamised/mäppimised,
// Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
// https://youtu.be/BrSMvqcGMio
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
// vajuta IntelliJ-s ka implement noolekesele, mis viib sind klassi (AccountMapperImpl),
// kus see interface klass on ära implementeeritud (ära lahendatud).
// See lahendus on siis MapStructi poolt genereeritud.

    // Mäpper (Entity -> Dto)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "firstName", source = "customer.firstName")
    @Mapping(target = "lastName", source = "customer.lastName")
    @Mapping(target = "isikukood", source = "customer.isikukood")
    AccountResponse toResponse(Account account);

    // Siin on ka mäpper, aga siin mäpitakse ühe klass objektide list, teise klassi objektideks.
    // Kui juba üksik objekti mäppimine on eelnevalt ära defineeritud (eelpool olev meetod 'toResponse)',
    // siis põhimõtteliselt tehakse for tsükkel ja taaskasutatakse seda sama meetodit uuesti.
    // Tänu sellele ei pea Listi mäppimisel enam siia meetodi peale mingeid mäpingu annotatsioone uuesti lisama.
    // Piisab sellest kui teeme copy paste üksik-objekti mäpperist copy-paste ja paneme nad 'List<>' sisse
    List<AccountResponse> toResponses(List<Account> account);

    // Mäpper (Dto -> Entity)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
    @Mapping(target = "id", ignore = true)
    Account toEntity(AccountDto dto);


    // Siin on ka mäpper, aga siin ei looda mäppimisel uut objekti vaid
    // uuendatakse andmeid Dto objekti pealt -> Entity objektile
    // Seda on siis hea kasutada, kui tahame mingi rea andmeid andmebaasis uuendada.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(AccountDto accountDto, @MappingTarget Account account);


}
