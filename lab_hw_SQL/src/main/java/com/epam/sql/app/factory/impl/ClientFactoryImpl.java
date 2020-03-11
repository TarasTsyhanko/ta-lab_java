package com.epam.sql.app.factory.impl;

import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.app.factory.ClientFactory;
import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.entity.Location;
import com.epam.sql.banksystem.service.BankService;
import com.epam.sql.banksystem.service.PersonService;
import com.epam.sql.banksystem.entity.Bank;
import com.epam.sql.banksystem.entity.Client;
import com.epam.sql.app.enums.ClientType;
import com.epam.sql.banksystem.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** S - single responsibility principle.
 *  O - open/close principle.
 *  L - liskov substitution principle.
 *  I - interface segregation principle.
 *  D - dependency  inversion principle.
*/
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
