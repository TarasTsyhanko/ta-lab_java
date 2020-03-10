package factory.impl;

import banksystem.MyConsole;
import banksystem.config.exception.InfoException;
import banksystem.entity.Location;
import banksystem.service.BankService;
import banksystem.service.PersonService;
import client.Bank;
import client.Client;
import client.ClientType;
import client.Person;
import factory.ClientFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientFactoryImpl implements ClientFactory {
    private static Logger log = LogManager.getLogger(ClientFactoryImpl.class);
    @Override
    public Client createClient(ClientType type) throws InfoException {
        Client client = null;
        if (ClientType.BANK == type) {
            client = new BankService().insertBank(createBank());
        } else if (ClientType.PERSON == type) {
            client = new PersonService().insertPerson(createPerson());
        }
        return client;
    }

    private Bank createBank() {
        Bank bank = new Bank();
        log.info("Write your name: ");
        bank.setName(MyConsole.readString());
        Location location = new Location();
        log.info("Write your country: ");
        location.setCountry(MyConsole.readString());
        log.info("Write your city: ");
        location.setCity(MyConsole.readString());
        log.info("Write your Street: ");
        location.setStreet(MyConsole.readString());
        log.info("Write your Street Number: ");
        location.setStreetNumber(MyConsole.readInt());
        bank.setLocation(location);
        return bank;
    }

    private Person createPerson() {
        Person person = new Person();
        log.info("Write your firstName: ");
        person.setFirstName(MyConsole.readString());
        log.info("Write your lastName: ");
        person.setLastName(MyConsole.readString());
        log.info("Write your age: ");
        person.setAge(MyConsole.readInt());
        log.info("Write your country: ");
        person.setCountry(MyConsole.readString());
        log.info("Write your email: ");
        person.setEmail(MyConsole.readString());
        return person;
    }
}
