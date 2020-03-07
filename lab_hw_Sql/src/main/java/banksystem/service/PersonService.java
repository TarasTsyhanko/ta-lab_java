package banksystem.service;

import banksystem.dao.DepositDAO;
import banksystem.dao.InvestmentDAO;
import banksystem.dao.LoanDAO;
import banksystem.dao.PersonDAO;
import banksystem.dao.databasedao.DepositDataBaseDAO;
import banksystem.dao.databasedao.InvestmentDataBaseDAO;
import banksystem.dao.databasedao.LoanDataBaseDAO;
import banksystem.dao.databasedao.PersonDataBaseDAO;
import banksystem.entity.Deposit;
import banksystem.entity.Investment;
import banksystem.entity.Loan;
import banksystem.entity.Person;

import java.util.List;

public class PersonService {
    private PersonDAO personDAO;
    private DepositDAO depositDAO;
    private LoanDAO loanDAO;
    private InvestmentDAO investmentDAO;

    public PersonService() {
        personDAO = new PersonDataBaseDAO();
        depositDAO = new DepositDataBaseDAO();
        loanDAO = new LoanDataBaseDAO();
        investmentDAO = new InvestmentDataBaseDAO();
    }

    public List<Person> getAllPerson(){
       return personDAO.getAllPerson();
    }

    public Person getPersonByName(String firstName, String lastName) {
        if (personDAO.isPersonExists(firstName, lastName)) {
            personDAO.getPersonByName(firstName, lastName);
        }
        return null;
    }

    public void InsertPerson(Person person) {
        if (!personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
            personDAO.insertPerson(person);
        }
    }
    public void updatePerson(Person person){
        personDAO.updatePerson(person);
    }

    public void deletePerson(Person person) {
        if (personDAO.isPersonExists(person.getFirstName(),person.getLastName())) {
            List<Loan> loanList = loanDAO.getAllLoanByClient(person.getId());
            List<Deposit> depositList = depositDAO.getAllDepositByClient(person.getId());
            List<Investment> investmentList = investmentDAO.getAllInvestmentByClient(person.getId());
            if (!loanList.isEmpty()) {
                loanList.forEach(loan -> loanDAO.deleteLoan(loan));
            }
            if (!depositList.isEmpty()) {
                depositList.forEach(deposit -> depositDAO.deleteDeposit(deposit));
            }
            if (!investmentList.isEmpty()) {
                investmentList.forEach(investment -> investmentDAO.deleteInvestment(investment));
            }
            personDAO.deletePerson(person);
        }
    }
}
