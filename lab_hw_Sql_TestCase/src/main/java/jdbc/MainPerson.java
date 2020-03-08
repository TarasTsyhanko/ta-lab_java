package jdbc;

import jdbc.dao.PersonBookDAO;
import jdbc.dao.PersonDAO;
import jdbc.entity.Person;
import jdbc.service.PersonBookService;
import jdbc.service.PersonService;

import java.util.List;

public class MainPerson {
    public static void main(String[] args) {
        PersonBookDAO personBookDAO = new PersonBookService();
        PersonDAO dao = new PersonService();
        List<Person> people = dao.getAllPerson();
        Person person = people.get(0);
        for (Person p :people) {
            System.out.println(p.getId()+"   "+p.getSurName()+"   "+p.getName()+"   "+p.getCity().getCityName()+"   "+p.getEmail());
        }
        personBookDAO.deletePersonBook(person);
        System.out.println("--------------------------------------------------------------------------------------");
        dao.deletePerson(person);
        people = dao.getAllPerson();
        for (Person p :people) {
            System.out.println(p.getId()+"   "+p.getSurName()+"   "+p.getName()+"   "+p.getCity().getCityName()+"   "+p.getEmail());
        }
        System.out.println("--------------------------------------------------------------------------------------");
        dao.insertPerson(person);
        people = dao.getAllPerson();
        for (Person p :people) {
            System.out.println(p.getId()+"   "+p.getSurName()+"   "+p.getName()+"   "+p.getCity().getCityName()+"   "+p.getEmail());
        }
    }
}
