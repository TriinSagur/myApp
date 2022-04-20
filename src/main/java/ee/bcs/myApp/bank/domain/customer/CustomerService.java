package ee.bcs.myApp.bank.domain.customer;

import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private ValidationService validationService;

    // See meetod on defineeritud nii, et ta võtab sisse CustomerDto tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama CustomerDto tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public CustomerDto addNewCustomer(CustomerDto customerDto) {

        // Kutsume paremal pool = märki välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        Customer customer = customerMapper.toEntity(customerDto);

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'customer' andmetele
        // see meetod save() on juba JpaRepository klassis endal olemas.
        // Seda meetodit save() me ei ole ise kuidagi loonud.
        // Kaasa anname vastava tabeli entity objekti, mis siis salvestatakse ka ühe reana andmebaasi tabelisse maha.
        customerRepository.save(customer);

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toDto()' tulemuse
        // Peale return'i minnakse sellest defineeritud addNewCustomer() meetodist välja
        return customerMapper.toDto(customer);
    }

    // See meetod on defineeritud nii, et mingeid parameetreid (andmeid) ta sisse ei võta
    // See meetod peab tagastama List<CustomerDto> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<CustomerDto> getAllCustomers() {

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findAll() on juba JpaRepository klassis endal olemas.
        // Seda meetodit findAll() me ei ole ise kuidagi loonud.
        // Vaata ka klassi CustomerRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina (Listina)
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        List<Customer> allCustomers = customerRepository.findAll();

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toDtos()' tulemuse
        // Peale return'i minnakse sellest defineeritud getAllCustomers() meetodist välja
        return customerMapper.toDtos(allCustomers);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama CustomerDto tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public CustomerDto findCustomerById(Integer id) {

        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Customer customer = getValidCustomerById(id);

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toDto()' tulemuse
        // Peale return'i minnakse sellest defineeritud findCustomerById() meetodist välja
        return customerMapper.toDto(customer);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void removeCustomerById(Integer customerId) {

        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Customer customer = getValidCustomerById(customerId);

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod deleteById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit deleteById() me ei ole ise kuidagi loonud.
        // Kaasa antakse id ning vastava ID'ga rida kustutatakse tabelist ära
        customerRepository.deleteById(customer.getId());
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer ja CustomerDto tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void updateCustomerById(Integer customerId, CustomerDto customerDto) {

        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Customer customer = getValidCustomerById(customerId);

        // Kutsume paremal pool = märki välja ühe mäpperi meetodi ja anname talle kaasa dto ja entity objektid
        // mille sees on siis mingid andmed.
        // Uuendatakse andmeid Dto objekti pealt -> Entity objektile
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        customerMapper.updateEntity(customerDto, customer);

        // Siin kasutame customerRepository (värav) objekti, et saada ligi tabeli 'customer' andmetele
        // see meetod save() on juba JpaRepository klassis endal olemas.
        // Seda meetodit save() me ei ole ise kuidagi loonud.
        // Kaasa anname vastava tabeli entity objekti, mis siis salvestatakse ka ühe reana andmebaasi tabelisse maha.
        // Tähtis on ka teada, et peale save() meetodist läbi käimist, uundatakse ka selle objekti välja 'id' väärtust
        // mis saadakse adnmebaasi tabelist (järgmine vaba id, primary key veerus)
        customerRepository.save(customer);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama Customer tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    private Customer getValidCustomerById(Integer customerId) {

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame customerRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit findById() me ei ole ise kuidagi loonud.
        // Repositorys juba olemas olevad 'find' meetodid tagastavad klassi objekte, mis on omakorda Optional<> klassi sees.
        // See on hea kuna Optional klassil on olemas mõned head meetodid nagu näiteks isEmpty() ja isPresent()
        // Repositorys juba olemas olevad 'get' meetodid tagastavad klassi objekte, mis ei ole Optional<> klassi sisse mähitud.
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina (mis on omakorda Optional<> klassi sees).
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Optional<Customer> customer = customerRepository.findById(customerId);

        // Kutsume välja ühte ValidationService klassis olevat meetodit.
        // Teeme mingi kontrolli ja vajadusel viskame ülesse mingi vea,
        // mille controller tagastab serverist välja koos vastava HTTP status koodi ja JSON sõnumina.
        // Vaata seda meetodit ka ValidationService klassi sees
        validationService.customerExists(customerId, customer);

        // Siin vaatleme kõigepealt "return'i" paremat poolt.
        // Meie defineeritud meetod getValidCustomerById() peab tagastama Customer klassi objekti.
        // Hetkel on selles muutujas Optional<Customer> tüüpi objekt.
        // .get() abil saame selle Optional'i seest selle Customer tüüpi objekti kätte.
        return customer.get();
    }


}
