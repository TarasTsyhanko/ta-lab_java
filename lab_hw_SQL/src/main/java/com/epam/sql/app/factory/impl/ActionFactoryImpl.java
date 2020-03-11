package com.epam.sql.app.factory.impl;

import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.app.enums.Action;
import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.entity.ClientAccount;
import com.epam.sql.banksystem.service.ClientAccountService;
import com.epam.sql.app.enums.ClientType;
import com.epam.sql.app.factory.ActionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *  O - open/close principle.
 *  L - liskov substitution principle.
 *  I - interface segregation principle.
 *  D - dependency  inversion principle.
 */

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
                } catch (InfoException  | IllegalArgumentException e) {
                    b = true;
                    log.error("Exception msg " + e.getMessage());
                }
            } while (b);
        } else {
            log.info("Select your status:\n - BANK\n - PERSON");
            try {
                account = new AccountFactory().createAccount(ClientType.valueOf(MyConsole.readString().toUpperCase()));
            } catch (InfoException | IllegalArgumentException e) {
                log.info("Exception msg : " + e.getMessage());
            }
        }
        return account;
    }
}
