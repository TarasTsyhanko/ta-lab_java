package com.epam.sql.app.factory.impl;

import com.epam.sql.app.factory.Personality;
import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.service.BankService;
import com.epam.sql.banksystem.service.PersonService;
import com.epam.sql.banksystem.entity.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** S - single responsibility principle.
 *  O - open/close principle.
 *  L - liskov substitution principle.
 *  I - interface segregation principle.
 *  D - dependency  inversion principle.
 */

public class PersonalityImpl implements Personality {
    private static Logger log = LogManager.getLogger(AccountFactory.class);

    @Override
    public Client getPersonalDateOfClient(int IdClient) {
        Client client = null;
        try {
            client = new PersonService().getPersonById(IdClient);
        } catch (InfoException e) {
            log.error("Exception msg :"+e.getMessage());
        }
        if (client!=null) {
                return client;
            } else {
            try {
                client= new BankService().getBankById(IdClient);
            } catch (InfoException e) {
                log.error("Exception msg :"+e.getMessage());
            }
        }
        return client;
    }
}
