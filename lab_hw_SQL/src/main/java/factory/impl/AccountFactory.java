package factory.impl;

import banksystem.MyConsole;
import banksystem.config.exception.InfoException;
import banksystem.entity.ClientAccount;
import banksystem.service.ClientAccountService;
import client.Client;
import client.ClientType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountFactory {
    private static Logger log = LogManager.getLogger(AccountFactory.class);

    public ClientAccount createAccount(ClientType type) throws InfoException {
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
