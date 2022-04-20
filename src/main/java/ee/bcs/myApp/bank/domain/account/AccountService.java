package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.customer.CustomerRepository;
import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    // @Resource abiga saab Spring teha meile ligipääsu:
    // @Service, @Component, @Mapper, @Repository, jne annotatsiooniga klassidele
    @Resource
    private AccountRepository accountRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private ValidationService validationService;


    // See meetod on defineeritud nii, et ta võtab sisse AccountDto tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama AccountResponse tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public AccountResponse addNewAccount(AccountDto accountDto) {
        // Võtame addNewAccount() signatuuri parameetris sisse AccountDto tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'accountDto'

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame customerRepository (värav) objekti, et saada ligi tabeli 'customer' andmetele
        // see meetod getById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit getById() me ei ole ise kuidagi loonud.
        // Vaata ka klassi CustomerRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Customer customer = customerRepository.getById(accountDto.getCustomerId());

        // Kutsume paremal pool = märki välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        Account account = accountMapper.toEntity(accountDto);

        // Need andmed mida me ei saanud mäpperiga ümber mäppida, peame me nüüd ise eraldi väärtustama
        // Kui JSON'is ja andmebaasis on meil foreign key 'id' väärtused (täisarvust numbrid, nt. 1,2,3,jne),
        // siis javas on meil nende numbrite asemel entity klassidest tehtud objektid
        account.setCustomer(customer);

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod save() on juba JpaRepository klassis endal olemas.
        // Seda meetodit save() me ei ole ise kuidagi loonud.
        // Kaasa anname vastava tabeli entity ja sellega salvestatakse andmed andmebaasi kenast ka maha.
        accountRepository.save(account);

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toResponse()' tulemuse
        // Peale return'i minnakse sellest defineeritud addNewAccount() meetodist välja
        return accountMapper.toResponse(account);
    }


    // See meetod on defineeritud nii, et mingeid parameetreid (andmeid) ta sisse ei võta
    // See meetod peab tagastama List<AccountResponse> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<AccountResponse> findAllAccounts() {

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findAll() on juba JpaRepository klassis endal olemas.
        // Seda meetodit findAll() me ei ole ise kuidagi loonud.
        // Vaata ka klassi CustomerRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina (Listina)
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        List<Account> accounts = accountRepository.findAll();


        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toResponses()' tulemuse
        // Peale return'i minnakse sellest defineeritud findAllAccounts() meetodist välja
        return accountMapper.toResponses(accounts);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama AccountResponse tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public AccountResponse findAccountInfoById(Integer id) {
        // Võtame findAccountInfoById() signatuuri parameetris sisse AccountDto tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'id'

        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Account account = getValidAccountById(id);

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toResponse()' tulemuse
        // Peale return'i minnakse sellest defineeritud findAccountInfoById() meetodist välja
        return accountMapper.toResponse(account);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void removeAccountById(Integer id) {
        // Võtame removeAccountById() signatuuri parameetris sisse Integer tüüpi objekti
        // Siin signatuuris antakse sellele objekti muutujale nimeks 'id'


        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Account account = getValidAccountById(id);

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod deleteById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit deleteById() me ei ole ise kuidagi loonud.
        // Kaasa antakse id ning vastava ID'ga rida kustutatakse tabelist ära
        accountRepository.deleteById(account.getId());
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer ja AccountDto tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void updateAccountById(Integer id, AccountDto accountDto) {

        // Siin vaatleme kõigepealt paremat poolt.
        // Kutsume välja siin samas klassis ära defineeritud meetodit
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        // Vaata ka selle väljakutsutava meetodi kommentaare
        Account account = getValidAccountById(id);

        // Kutsume paremal pool = märki välja ühe mäpperi meetodi ja anname talle kaasa dto ja entity objektid
        // mille sees on siis mingid andmed.
        // Uuendatakse andmeid Dto objekti pealt -> Entity objektile
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        accountMapper.updateEntity(accountDto, account);

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame customerRepository (värav) objekti, et saada ligi tabeli 'customer' andmetele
        // see meetod getById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit getById() me ei ole ise kuidagi loonud.
        // Vaata ka klassi CustomerRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Customer customer = customerRepository.getById(accountDto.getCustomerId());

        // Väärtustatakse account sees olev customer objekt.
        account.setCustomer(customer);
    }

    // See meetod on defineeritud nii, et ta võtab sisse String tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama List<AccountResponse> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<AccountResponse> findAccountsInfoByLastName(String lastName) {

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findByLastName() on meie enda loodud ja kirjutatud (JPA Buddy abiga).
        // Vaata ka seda meetodid klassi accountRepository sees.
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektidena (sest siin on List)
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        List<Account> accounts = accountRepository.findByLastName(lastName);

        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toResponses()' tulemuse
        // Peale return'i minnakse sellest defineeritud findAccountsInfoByLastName() meetodist välja
        return accountMapper.toResponses(accounts);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Account ja Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void updateCreditPaymentBalance(Account account, Integer amount) {

        // Siin vaatleme kõigepealt paremat poolt.
        // Võtame getter meetodi abil objektist välja, selle välja objekti
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Integer currentBalance = account.getBalance();

        // Siin vaatleme kõigepealt paremat poolt.
        // Teeme mingi arvutuse
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Integer newBalance = currentBalance + amount;

        // Setteriga väärtustakse objekti välja väärtus
        account.setBalance(newBalance);

        // Siin kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod save() on juba JpaRepository klassis endal olemas.
        // Seda meetodit save() me ei ole ise kuidagi loonud.
        // Kaasa anname vastava tabeli entity objekti, mis siis salvestatakse ka ühe reana andmebaasi tabelisse maha.
        // Tähtis on ka teada, et peale save() meetodist läbi käimist, uundatakse ka selle objekti välja 'id' väärtust
        // mis saadakse adnmebaasi tabelist (järgmine vaba id, primary key veerus)
        accountRepository.save(account);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Account ja Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void updateDebitPaymentBalance(Account account, Integer amount) {

        // Siin vaatleme kõigepealt paremat poolt.
        // Võtame getter meetodi abil objektist välja, selle välja objekti
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Integer currentBalance = account.getBalance();

        // Siin vaatleme kõigepealt paremat poolt.
        // Teeme mingi arvutuse
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Integer newBalance = currentBalance - amount;
        // Setteriga väärtustakse objekti välja väärtus
        account.setBalance(newBalance);

        // Siin kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod save() on juba JpaRepository klassis endal olemas.
        // Seda meetodit save() me ei ole ise kuidagi loonud.
        // Kaasa anname vastava tabeli entity objekti, mis siis salvestatakse ka ühe reana andmebaasi tabelisse maha.
        // Tähtis on ka teada, et peale save() meetodist läbi käimist, uundatakse ka selle objekti välja 'id' väärtust
        // mis saadakse adnmebaasi tabelist (järgmine vaba id, primary key veerus)
        accountRepository.save(account);
    }

    // See meetod on defineeritud nii, et ta võtab sisse String tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama Account tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public Account getValidAccountByAccountNumber(String accountNumber) {

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findByAccountNumber() on meie enda loodud ja kirjutatud (JPA Buddy abiga).
        // Vaata ka seda meetodid klassi accountRepository sees.
        // Saadud tulemus on Optional<> klassi sees.
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

        // Kutsume välja ühte ValidationService klassis olevat meetodit.
        // Teeme mingi kontrolli ja vajadusel viskame ülesse mingi vea,
        // mille controller tagastab serverist välja koos vastava HTTP status koodi ja JSON sõnumina.
        // Vaata seda meetodit ka ValidationService klassi sees
        validationService.accountExists(accountNumber, account);

        // Siin vaatleme kõigepealt "return'i" paremat poolt.
        // Meie defineeritud meetod getValidAccountByAccountNumber() peab tagastama Account klassi objekti.
        // Hetkel on selles muutujas Optional<Account> tüüpi objekt.
        // .get() abil saame selle Optional'i seest selle Account tüüpi objekti kätte.
        return account.get();
    }

    // See meetod on defineeritud nii, et ta võtab sisse String tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama Account tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public boolean accountExistsByAccountNumber(String accountNumber) {

        // Kutsume välja ühte ValidationService klassis olevat meetodit.
        // Teeme mingi kontrolli ja vajadusel viskame ülesse mingi vea,
        // mille controller tagastab serverist välja koos vastava HTTP status koodi ja JSON sõnumina.
        // Vaata seda meetodit ka ValidationService klassi sees
        return accountRepository.existsByAccountNumber(accountNumber);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod peab tagastama Account tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public Account getValidAccountById(Integer accountId) {

        // Siin vaatleme kõigepealt paremat poolt.
        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit findById() me ei ole ise kuidagi loonud.
        // Repositorys juba olemas olevad 'find' meetodid tagastavad klassi objekte, mis on omakorda Optional<> klassi sees.
        // See on hea kuna Optional klassil on olemas mõned head meetodid nagu näiteks isEmpty() ja isPresent()
        // Repositorys juba olemas olevad 'get' meetodid tagastavad klassi objekte, mis ei ole Optional<> klassi sisse mähitud.
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina (mis on omakorda Optional<> klassi sees).
        // Ning tulemus pannakse siin vasakul pool olevasse objekti.
        Optional<Account> account = accountRepository.findById(accountId);

        // Kutsume välja ühte ValidationService klassis olevat meetodit.
        // Teeme mingi kontrolli ja vajadusel viskame ülesse mingi vea,
        // mille controller tagastab serverist välja koos vastava HTTP status koodi ja JSON sõnumina.
        // Vaata seda meetodit ka ValidationService klassi sees
        validationService.accountExists(accountId, account);

        // Siin vaatleme kõigepealt "return'i" paremat poolt.
        // Meie defineeritud meetod getValidAccountById() peab tagastama Account klassi objekti.
        // Hetkel on selles muutujas Optional<Account> tüüpi objekt.
        // .get() abil saame selle Optional'i seest selle Account tüüpi objekti kätte.
        return account.get();
    }
}
