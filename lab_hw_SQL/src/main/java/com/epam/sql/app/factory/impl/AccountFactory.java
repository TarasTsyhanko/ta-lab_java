package com.epam.sql.app.factory.impl;

import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.banksystem.config.exception.SQLInfoException;
import com.epam.sql.banksystem.entity.ClientAccount;
import com.epam.sql.banksystem.service.ClientAccountService;
import com.epam.sql.banksystem.entity.Client;
import com.epam.sql.app.enums.ClientType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** S - single responsibility principle.
 *  O - open/close principle.
 *  L - liskov substitution principle.
 *  I - interface segregation principle.
 *  D - dependency  inversion principle.
 */

public class AccountFactory {
    private static Logger log = LogManager.getLogger(AccountFactory.class);

    public ClientAccount createAccount(ClientType type) throws SQLInfoException {
        Client client = new ClientFactoryImpl().createClient(type);
        ClientAccount account = new ClientAccount();
        account.setIDClient(client.getIdClient());
        log.info("Please , create your secret PAROLE:");
        account.setParole(MyConsole.readString());
        account = new ClientAccountService().insertAccount(account);
        log.info("You successfully create account\nYour LOGIN - "
                + account.getLogin() + "\nYour PAROLE - " + account.getParole());
        return account;
    }
}
