package ee.bcs.myApp.bank.domain.account;

import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.bank.domain.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

        // kasutame customerRepository (värav) objekti, et saada ligi tabeli 'customer' andmetele
        // see meetod getById() on juba JpaRepository klassis endal olemas.
        // seda meetodit getById() me ei ole ise kuidagi loonud.
        // Vaata ka klassi CustomerRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina
        // Ning tulemuse pannakse siin vasakul pool olevasse objekti.
        Customer customer = customerRepository.getById(accountDto.getCustomerId());

        // Kutsume paremal pool = märki välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
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
        // Peale return'i minnakse sellest defineeritud getTransactionsByAccountId() meetodist välja
        return accountMapper.toResponse(account);
    }


    // See meetod on defineeritud nii, et mingeid parameetreid (andmeid) ta sisse ei võta
    // See meetod peab tagastama List<AccountResponse> tüüpi objekti
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public List<AccountResponse> findAllAccounts() {

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findAll() on juba JpaRepository klassis endal olemas.
        // seda meetodit getById() me ei ole ise kuidagi loonud.
        // Vaata ka klassi CustomerRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina (Listina)
        // Ning tulemuse pannakse siin vasakul pool olevasse objekti.
        List<Account> accounts = accountRepository.findAll();


        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toResponses()' tulemuse
        // Peale return'i minnakse sellest defineeritud getTransactionsByAccountId() meetodist välja
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

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod getById() on juba JpaRepository klassis endal olemas.
        // seda meetodit getById() me ei ole ise kuidagi loonud.
        // Vaata ka klassi AccountRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina
        // Ning tulemuse pannakse siin vasakul pool olevasse objekti.
        Account account = accountRepository.getById(id);

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

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod deleteById() on juba JpaRepository klassis endal olemas.
        // Seda meetodit deleteById() me ei ole ise kuidagi loonud.
        // Kaasa antakse id ning vastava ID'ga rida kustutatakse tabelist ära
        accountRepository.deleteById(id);
    }

    // See meetod on defineeritud nii, et ta võtab sisse Integer ja AccountDto tüüp objekti
    // See on selleks vajalik, et me saaksime siin meetodis selle objekti andmetega kuidagi toimetada.
    // See meetod on void. Ta ei tagasta midagi.
    // Kui meetodite teema on veel endiselt segane, siis palun vaata uuesti "Meetodid", "Meetodite signatuurid" ja "Public ja Private meetodid":
    // https://youtu.be/EI3XfkdPBc4
    // https://youtu.be/GvP68LBZiUA
    // https://youtu.be/4ZkvNfu9kNw
    public void updateAccountById(Integer id, AccountDto accountDto) {

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod getById() on juba JpaRepository klassis endal olemas.
        // seda meetodit getById() me ei ole ise kuidagi loonud.
        // Vaata ka klassi AccountRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina
        // Ning tulemuse pannakse siin vasakul pool olevasse objekti.
        Account account = accountRepository.getById(id);

        // Kutsume paremal pool = märki välja ühe mäpperi meetodi ja anname talle kaasa dto ja entity objektid
        // mille sees on siis mingid andmed.
        // Uuendatakse andmeid Dto objekti pealt -> Entity objektile
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        accountMapper.updateEntity(accountDto, account);

        // kasutame customerRepository (värav) objekti, et saada ligi tabeli 'customer' andmetele
        // see meetod getById() on juba JpaRepository klassis endal olemas.
        // seda meetodit getById() me ei ole ise kuidagi loonud.
        // Vaata ka klassi CustomerRepository sisse
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektina
        // Ning tulemuse pannakse siin vasakul pool olevasse objekti.
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

        // kasutame accountRepository (värav) objekti, et saada ligi tabeli 'account' andmetele
        // see meetod findByLastName() on meie enda loodud ja kirjutatud (JPA Buddy abiga).
        // Vaata ka seda meetodid klassi accountRepository sees.
        // Saadud tabelist saame selle meetodiga vajalikud andmed, mis nüüd tagastatakse entity objektidena (sest siin on List)
        // Ning tulemuse pannakse siin vasakul pool olevasse objekti.
        List<Account> accounts = accountRepository.findByLastName(lastName);


        // Siin vaatleme kõigepealt "return'i" paremat poolt. Kutsume välja ühe mäpperi meetodi ja anname talle kaasa ka mingi objekti,
        // mille sees on siis mingid andmed.
        // Luuakse uut tüüpi objekt (mingist teisest klassist)
        // ja siis mäpitakse (kaardistatakse ja väärtustatakse) andmed uuele objektile ümber.
        // Kui mäpperite teema on veel endiselt segane, siis palun vaata uuesti "MapStruct mappimine":
        // https://youtu.be/BrSMvqcGMio
        // Tagastame RETURN statement'iga 'toResponses()' tulemuse
        // Peale return'i minnakse sellest defineeritud getTransactionsByAccountId() meetodist välja
        return accountMapper.toResponses(accounts);
    }

    public Account findAccountById(Integer accountId) {
        return accountRepository.getById(accountId);
    }
}
