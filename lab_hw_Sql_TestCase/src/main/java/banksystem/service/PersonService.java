package banksystem.service;

import banksystem.config.exception.InfoException;
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

    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }

    public Person getPersonByName(String firstName, String lastName) throws InfoException {
        if (personDAO.isPersonExists(firstName, lastName)) {
            return personDAO.getPersonByName(firstName, lastName);
        }else throw  new InfoException("This person is absent");
    }

    public Person insertPerson(Person person) throws InfoException {
        if (!personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
            personDAO.insertPerson(person);
            return personDAO.getPersonByName(person.getFirstName(), person.getLastName());
        } else throw new InfoException("This person already exists");
    }

    public Person updatePerson(Person person) throws InfoException {
        Person personDB = personDAO.getPersonById(person.getId());
        if (person.getFirstName().equals(personDB.getFirstName()) && person.getLastName().equals(personDB.getLastName())) {
            personDAO.updatePerson(person);
        } else {
            if (personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
                throw new InfoException("Person with this Name already exists");
            } else personDAO.updatePerson(person);
        }
        return personDAO.getPersonById(person.getId());
    }

    public void deletePerson(Person person) throws InfoException {
        if (personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
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
        }else throw new InfoException("This person is absent");
    }
}
