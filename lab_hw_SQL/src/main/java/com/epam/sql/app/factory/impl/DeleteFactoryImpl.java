package com.epam.sql.app.factory.impl;

import com.epam.sql.app.enums.ClientType;
import com.epam.sql.app.factory.DeleteFactory;
import com.epam.sql.banksystem.config.exception.SQLInfoException;
import com.epam.sql.banksystem.entity.Bank;
import com.epam.sql.banksystem.entity.Client;
import com.epam.sql.banksystem.entity.Person;
import com.epam.sql.banksystem.service.BankService;
import com.epam.sql.banksystem.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** S - single responsibility principle.
 *  O - open/close principle.
 *  L - liskov substitution principle.
 *  I - interface segregation principle.
 *  D - dependency  inversion principle.
 */

public class DeleteFactoryImpl implements DeleteFactory {
    private static Logger log = LogManager.getLogger(DeleteFactoryImpl.class);
    @Override
    public void deleteClient(Client client) {
        try {
            if (client.getClientType() == ClientType.BANK) {
                Bank bank = (Bank) client;
                new BankService().deleteBank(bank);
            } else {
                Person person = (Person) client;
                new PersonService().deletePerson(person);
            }
        } catch (SQLInfoException e) {
            log.error("Exception msg :"+e.getMessage());
        }
    }
}
