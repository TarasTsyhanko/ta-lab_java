package com.epam.sql.banksystem.service;

import com.epam.sql.app.factory.impl.AccountFactory;
import com.epam.sql.banksystem.config.exception.SQLInfoException;
import com.epam.sql.banksystem.dao.ClientAccountDAO;
import com.epam.sql.banksystem.dao.OperationDAO;
import com.epam.sql.banksystem.dao.PersonDAO;
import com.epam.sql.banksystem.dao.databasedao.ClientAccountDataBaseDAO;
import com.epam.sql.banksystem.dao.databasedao.OperationDataBaseDAO;
import com.epam.sql.banksystem.dao.databasedao.PersonDataBaseDAO;
import com.epam.sql.banksystem.entity.ClientAccount;
import com.epam.sql.banksystem.entity.Operation;
import com.epam.sql.banksystem.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private static Logger log = LogManager.getLogger(AccountFactory.class);
    private ClientAccountDAO<ClientAccount> clientAccountDAO;
    private PersonDAO<Person> personDAO;
    private OperationDAO<Operation> operationDAO;

    public PersonService() {
        clientAccountDAO = new ClientAccountDataBaseDAO();
        personDAO = new PersonDataBaseDAO();
        operationDAO = new OperationDataBaseDAO();
    }

    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }

    public Person getPersonByName(String firstName, String lastName) throws SQLInfoException {
        if (personDAO.isPersonExists(firstName, lastName)) {
            return personDAO.getPersonByName(firstName, lastName);
        }else throw  new SQLInfoException("This person is absent");
    }
    public Person getPersonById(int id) throws SQLInfoException {
        List<Person> people =  personDAO.getAllPerson().stream().filter(p->p.getId()==id).collect(Collectors.toList());
        if(people.isEmpty()){
           throw new SQLInfoException("This person is absent") ;
        }
        return people.get(0);
    }

    public Person insertPerson(Person person) throws SQLInfoException {
        if (!personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
            personDAO.insertPerson(person);
            return personDAO.getPersonByName(person.getFirstName(), person.getLastName());
        } else throw new SQLInfoException("This person already exists");
    }

    public Person updatePerson(Person person) throws SQLInfoException {
        Person personDB = getPersonById(person.getId());
        if (person.getFirstName().equals(personDB.getFirstName()) && person.getLastName().equals(personDB.getLastName())) {
            personDAO.updatePerson(person);
        } else {
            if (personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
                throw new SQLInfoException("Person with this Name already exists");
            } else personDAO.updatePerson(person);
        }
        return getPersonById(person.getId());
    }

    public void deletePerson(Person person) throws SQLInfoException {
        if (personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
            List<Operation> loanList = null;
            try {
                loanList = new OperationService().getAllOperationIByClient(person.getIdClient());
            } catch (SQLInfoException e) {
                log.error("Exception msg :"+e.getMessage());
            }
            if (loanList!=null) {
                loanList.forEach(loan -> operationDAO.deleteOperation(loan));
            }
            clientAccountDAO.deleteAccount(clientAccountDAO.getAccountByIDClient(person.getId()));
            personDAO.deletePerson(person);
        }else throw new SQLInfoException("This person is absent");
    }
}
