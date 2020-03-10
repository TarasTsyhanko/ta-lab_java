package banksystem.service;

import banksystem.config.exception.InfoException;
import banksystem.dao.OperationDAO;
import banksystem.dao.PersonDAO;
import banksystem.dao.databasedao.OperationDataBaseDAO;
import banksystem.dao.databasedao.PersonDataBaseDAO;
import banksystem.entity.Operation;
import client.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private PersonDAO personDAO;
    private OperationDAO operationDAO;

    public PersonService() {
        personDAO = new PersonDataBaseDAO();
        operationDAO = new OperationDataBaseDAO();
    }

    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }

    public Person getPersonByName(String firstName, String lastName) throws InfoException {
        if (personDAO.isPersonExists(firstName, lastName)) {
            return personDAO.getPersonByName(firstName, lastName);
        }else throw  new InfoException("This person is absent");
    }
    public Person getPersonById(int id) throws InfoException {
        List<Person> people =  personDAO.getAllPerson().stream().filter(p->p.getId()==id).collect(Collectors.toList());
        if(people.isEmpty()){
           throw new InfoException("This person is absent") ;
        }
        return people.get(0);
    }

    public Person insertPerson(Person person) throws InfoException {
        if (!personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
            personDAO.insertPerson(person);
            return personDAO.getPersonByName(person.getFirstName(), person.getLastName());
        } else throw new InfoException("This person already exists");
    }

    public Person updatePerson(Person person) throws InfoException {
        Person personDB = getPersonById(person.getId());
        if (person.getFirstName().equals(personDB.getFirstName()) && person.getLastName().equals(personDB.getLastName())) {
            personDAO.updatePerson(person);
        } else {
            if (personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
                throw new InfoException("Person with this Name already exists");
            } else personDAO.updatePerson(person);
        }
        return getPersonById(person.getId());
    }

    public void deletePerson(Person person) throws InfoException {
        if (personDAO.isPersonExists(person.getFirstName(), person.getLastName())) {
            List<Operation> loanList = new OperationService().getAllOperationIByClient(person.getIdClient());
            if (!loanList.isEmpty()) {
                loanList.forEach(loan -> operationDAO.deleteOperation(loan));
            }
            personDAO.deletePerson(person);
        }else throw new InfoException("This person is absent");
    }
}
