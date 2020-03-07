package babksystemtests;

import banksystem.config.exception.InfoException;
import banksystem.config.parser.ParserJSon;
import banksystem.entity.*;
import banksystem.service.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.List;

public abstract class BaseTest {
    protected PersonService personService;
    protected BankService bankService;
    protected LocationService locationService;
    protected DepositService depositService;
    protected LoanService loanService;
    protected InvestmentService investmentService;

    protected List<Person> personList = new ParserJSon().getPersons();
    protected List<Bank> bankList = new ParserJSon().getBanks();
    protected List<Location> locationList = new ParserJSon().getLocations();
    protected List<Deposit> depositList = new ParserJSon().getDeposits();
    protected List<Loan> loanList = new ParserJSon().getLoans();
    protected List<Investment> investmentList = new ParserJSon().getInvestments();

    @BeforeClass(groups = {"babksystemtests.BankTest","babksystemtests.LocationTest","babksystemtests.LoanTest"})
    public void reinitialize() {
        personService = new PersonService();
        bankService = new BankService();
        locationService = new LocationService();
        depositService = new DepositService();
        loanService = new LoanService();
        investmentService = new InvestmentService();

    }
    @BeforeClass(groups = {"babksystemtests.BankTest" })
    public void test(){
         personList.forEach(person -> personService.InsertPerson(person));
        locationList.forEach(location -> {
            try {
                locationService.insertLocation(location);
            } catch (InfoException e) {
                e.printStackTrace();
            }
        });

    }

    @AfterSuite
    public void clearDataBase() {
        personService.getAllPerson().forEach(person -> personService.deletePerson(person));
        bankService.getAllBanks().forEach(bank -> {
            try {
                bankService.deleteBank(bank);
            } catch (InfoException e) {
                e.printStackTrace();
            }
        });
        locationService.getAllLocation().forEach(location -> {
            try {
                locationService.deleteLocation(location);
            } catch (InfoException e) {
                e.printStackTrace();
            }
        });
    }
}
