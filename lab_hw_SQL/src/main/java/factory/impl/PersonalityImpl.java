package factory.impl;

import banksystem.config.exception.InfoException;
import banksystem.service.BankService;
import banksystem.service.PersonService;
import client.Client;
import factory.Personality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonalityImpl implements Personality {
    private static Logger log = LogManager.getLogger(AccountFactory.class);
    @Override
    public Client getPersonalDateOfClient(int IdClient) {
        Client client = null;
        try {
            client = new PersonService().getPersonById(IdClient);
        } catch (InfoException e) {
            log.error("Exception msg: "+e.getMessage());
        }
        if(client.getIdClient()==IdClient){
            return client;
        }else  return new BankService().getBankById(IdClient);
    }
}
