package factory.impl;

import banksystem.MyConsole;
import banksystem.config.exception.InfoException;
import banksystem.service.BankService;
import banksystem.service.PersonService;
import client.Bank;
import client.Client;
import client.ClientType;
import client.Person;
import factory.UpdateClientFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateClientImpl implements UpdateClientFactory {
    private static Logger log = LogManager.getLogger(AccountFactory.class);
    @Override
    public Client updateClient(Client client){
        Client upClient = client;
        try {
            if (upClient.getClientType() == ClientType.BANK) {
                client = new BankService().updateBank(updateBank(client));
            } else {
                client = new PersonService().updatePerson(updatePerson(upClient));
            }
            return client;
        }catch (InfoException e){
            log.info("Exception msg :"+e.getMessage());
        }
        return client;
    }
    private Person updatePerson(Client client){
        Person person =(Person)client;
        String key;
        do {
            log.info("   ------------------------------------------------------");
            log.info("   |     1 - Change FirstName  |    2 - Change Last Name |");
            log.info("   |     3 - Change Country    |    4 - Change Email     |");
            log.info("   |                     Q - update                      |");
            log.info("   ------------------------------------------------------");
            log.info("   |                Please, select menu point.           |");
            log.info("   ------------------------------------------------------");
            key = MyConsole.readString().toUpperCase();
            try {
                switch (key) {
                    case "1":
                        log.info("Input First Name :");
                        person.setFirstName(MyConsole.readString());
                        break;
                    case "2":
                        log.info("Input Last Name :");
                        person.setLastName(MyConsole.readString());
                        break;
                    case "3":
                        log.info("Input County :");
                        person.setCountry(MyConsole.readString());
                        break;
                    case "4":
                        log.info("Input email :");
                       person.setEmail(MyConsole.readString());
                        break;
                }
            } catch (Exception ignored) {
            }
        } while (!key.equals("Q"));
        return person;
    }

    private Bank updateBank(Client client){
        Bank bank =(Bank) client;
        String key;
        do {
            log.info("   ---------------------------------------------------");
            log.info("   |     1 - Change Bank Name  |    2 - Change County |");
            log.info("   |     3 - Change City       |    4 - Change Street |");
            log.info("   |     5 - Change Number     |                      |");
            log.info("   |                     Q - update                   |");
            log.info("   ---------------------------------------------------");
            log.info("   |                Please, select menu point.        |");
            log.info("   ---------------------------------------------------");
            key = MyConsole.readString().toUpperCase();
            try {
                switch (key) {
                    case "1":
                        log.info("Input Bank Name :");
                        bank.setName(MyConsole.readString());
                        break;
                    case "2":
                        log.info("Input  country :");
                        bank.getLocation().setCountry(MyConsole.readString());
                        break;
                    case "3":
                        log.info("Input  city :");
                        bank.getLocation().setCity(MyConsole.readString());
                        break;
                    case "4":
                        log.info("Input  street :");
                        bank.getLocation().setStreet(MyConsole.readString());
                        break;
                    case "5":
                        log.info("Input building number :");
                        bank.getLocation().setStreetNumber(MyConsole.readInt());
                        break;
                }
            } catch (Exception ignored) {
            }
        } while (!key.equals("Q"));
        return bank;
    }
}
