package ee.bcs.myApp.bank.domain.customer;

import org.mapstruct.*;

import java.util.List;

// Selle annotatsiooniga võetakse siin klassis kasutusele MapStruct tehnoloogia,
// mis genereerib meile annotatsioonide kaasabil automaatselt ise ära vajalikud andmete kaardistamised/mäppimised,
// Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
// https://youtu.be/BrSMvqcGMio
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
// vajuta IntelliJ-s ka implement noolekesele, mis viib sind klassi (CustomerMapperImpl),
// kus see interface klass on ära implementeeritud (ära lahendatud).
// See lahendus on siis MapStructi poolt genereeritud.

    // Mäpper (Dto -> Entity)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
    // @Mapping(target = "id", ignore = true) - sellega defineerime mäpperi nii, et target klassi 'id' välja me ei väärtusta
    // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
    // https://youtu.be/BrSMvqcGMio
    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDto dto);


    // Mäpper (Entity -> Dto)
    // Luuakse uut tüüpi objekt (mingist teisest klassist)
    // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
    // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
    // https://youtu.be/BrSMvqcGMio
    CustomerDto toDto(Customer entity);

    // Siin on ka mäpper, aga siin mäpitakse ühe klass objektide list, teise klassi objektideks.
    // Kui juba üksik objekti mäppimine on eelnevalt ära defineeritud (eelpool olev meetod 'toDto)',
    // siis põhimõtteliselt tehakse for tsükkel ja taaskasutatakse seda sama meetodit uuesti.
    // Tänu sellele ei pea Listi mäppimisel enam siia meetodi peale mingeid mäpingu annotatsioone uuesti lisama.
    // Piisab sellest kui teeme copy paste üksik-objekti mäpperist copy-paste ja paneme nad 'List<>' sisse
    // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
    // https://youtu.be/BrSMvqcGMio
    List<CustomerDto> toDtos(List<Customer> entities);

    // Siin on ka mäpper, aga siin ei looda mäppimisel uut objekti vaid
    // uuendatakse andmeid Dto objekti pealt -> Entity objektile
    // Seda on siis hea kasutada, kui tahame mingi rea andmeid andmebaasis uuendada.
    // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
    // https://youtu.be/BrSMvqcGMio
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    // @Mapping(target = "id", ignore = true) - sellega defineerime mäpperi nii, et target klassi 'id' välja me ei väärtusta
    @Mapping(target = "id", ignore = true)
    void updateEntity(CustomerDto dto, @MappingTarget Customer entity);
}
