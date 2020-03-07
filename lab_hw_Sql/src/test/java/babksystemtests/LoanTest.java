package babksystemtests;

import banksystem.config.exception.InfoException;
import banksystem.entity.Bank;
import banksystem.entity.Loan;
import banksystem.entity.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test(priority = 3)
public class LoanTest extends BaseTest {
    Loan loan = loanList.get(0);
    List<Person> persons;
    List<Bank> banks;

    @Test(priority = 1)
    public void getBankAndPerson(){
        persons = personService.getAllPerson();
        banks = bankService.getAllBanks();
    }
    @Test(priority = 1)
    public void insertLoanTestCase() throws InfoException {
        loan.setIDBank(banks.get(0).getId());
        loan.setIDClient(persons.get(0).getId());
        loanService.insertLoan(loan);
        Assert.assertEquals(loan, loanService.getAllLoanInOneBank(banks.get(0)).get(0));
    }

    @Test(priority = 2,
            expectedExceptions = {InfoException.class},
            expectedExceptionsMessageRegExp = "This Client already has LOAN in this Bank")
    public void insertLoanWithSameClientInSameBankTestCase() throws InfoException {
        Loan newLoan = loanList.get(1);
        loan.setIDBank(banks.get(0).getId());
        loan.setIDClient(persons.get(0).getId());
        loanService.insertLoan(loan);
    }

    @Test(priority = 3)
    public void insertLoanIfClientBankTestCase() throws InfoException {
        Loan newLoan = loanList.get(1);
        newLoan.setIDBank(banks.get(0).getId());
        newLoan.setIDClient(banks.get(1).getId());
        loanService.insertLoan(newLoan);
        Assert.assertEquals(newLoan, loanService.getAllLoanIByClient(banks.get(1).getId()).get(0));
    }
    public void insertLoanIntoAnotherBankTestCase() throws InfoException {
        Loan newLoan = loanList.get(2);
        newLoan.setIDBank(banks.get(1).getId());
        newLoan.setIDClient(persons.get(0).getId());
        loanService.insertLoan(loan);
        Assert.assertEquals(2, loanService.getAllLoanIByClient(persons.get(0).getId()).size());
    }

}
