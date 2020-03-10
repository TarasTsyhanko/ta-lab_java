package factory.impl;

import banksystem.MyConsole;
import banksystem.config.exception.InfoException;
import banksystem.entity.ClientAccount;
import banksystem.service.ClientAccountService;
import client.Action;
import client.ClientType;
import factory.ActionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionFactoryImpl implements ActionFactory {
    private static Logger log = LogManager.getLogger(AccountFactory.class);

    @Override
    public ClientAccount openAccount(Action action) {
        ClientAccount account = null;
        if (Action.LOGIN == action) {
            boolean b;
            do {
                b = false;
                log.info("Write your login :");
                int login = MyConsole.readInt();
                log.info("Write your parole :");
                String parole = MyConsole.readString();
                try {
                    account = new ClientAccountService().openAccount(login, parole);
                } catch (InfoException e) {
                    b = true;
                    log.error("Exception msg " + e.getMessage());
                }
            } while (b);
        } else {
            log.info("Select your status:\n - BANK\n - PERSON");
            try {
                account = new AccountFactory().createAccount(ClientType.valueOf(MyConsole.readString().toUpperCase()));
            } catch (InfoException e) {
                log.info("Exception msg : " + e.getMessage());
            }
        }
        return account;
    }
}
