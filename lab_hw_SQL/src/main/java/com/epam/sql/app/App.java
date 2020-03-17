package com.epam.sql.app;

import com.epam.sql.app.enums.Action;
import com.epam.sql.app.enums.ClientType;
import com.epam.sql.app.factory.*;
import com.epam.sql.app.factory.impl.*;
import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.banksystem.config.exception.SQLInfoException;
import com.epam.sql.banksystem.entity.*;
import com.epam.sql.banksystem.service.BankService;
import com.epam.sql.banksystem.service.ClientAccountService;
import com.epam.sql.banksystem.service.OperationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    private static Logger log = LogManager.getLogger(App.class);
    private UpdateClientFactory updateClient;
    private UpdateOperation updateOperation;
    private ActionFactory actionFactory;
    private DeleteFactory deleteFactory;
    private Personality personality;
    private OperationService operationService;
    private ClientAccountService accountService;
    private BankSystem bankSystem;
    private ClientAccount account;
    private Client client;
    private Bank bankDB;
    private List<Operation> operationList;

    public App() {
        operationService = new OperationService();
        accountService = new ClientAccountService();
        updateOperation = new UpdateOperationImpl();
        updateClient = new UpdateClientImpl();
        actionFactory = new ActionFactoryImpl();
        personality = new PersonalityImpl();
        bankSystem = new BankSystemImpl();
        deleteFactory = new DeleteFactoryImpl();
        account = new ClientAccount();
        operationList = new ArrayList<>();
    }

    public void logInAccount() {
        log.info("         Welcome to App");
        log.info("Press - 1 - to REGISTRATION\n Press - 2 - to LOG IN");
        int number = MyConsole.readInt();
        if (number == 1) {
            account = actionFactory.openAccount(Action.REGISTRATION);
        } else account = actionFactory.openAccount(Action.LOGIN);
    }

    public void showPersonalDate() {
        client = personality.getPersonalDateOfClient(account.getIDClient());
        Bank bank;
        Person person;
        if (client.getClientType() == ClientType.BANK) {
            bank = (Bank) client;
            log.info(bank.getName() + " | " + bank.getLocation().getCountry()
                    + " | " + bank.getLocation().getCity() + " | " + bank.getLocation().getStreet()
                    + " " + bank.getLocation().getStreetNumber());
        } else if ((client.getClientType() == ClientType.PERSON)) {
            person = (Person) client;
            log.info(person.getFirstName() + " " + person.getLastName()
                    + " | Age: " + person.getAge() + " | " + person.getCountry()
                    + " | " + person.getEmail());
        }
        log.info("");
    }

    public void changePersonalDate() {
        updateClient.updateClient(client);
    }

    public void changeOperationTerm() {
        showAllOperation();
        log.info(" - Which Operation You wanna change ?");
        updateOperation.updateOperation(operationList.get(MyConsole.readInt() - 1));
    }


    public void chooseBank() {
        List<Bank> banks = new BankService().getAllBanks()
                .stream().filter(bank1 -> bank1.getId() != client.getIdClient())
                .collect(Collectors.toList());
        int n = 1;
        for (Bank b : banks) {
            log.info("Press " + n + " to choose -- " + b.getName());
            n++;
        }
        bankDB = banks.get(MyConsole.readInt() - 1);
    }

    public void workWithBank() {
        log.info("        Welcome to the " + bankDB.getName());
        log.info("Location : " + bankDB.getLocation().getCountry() + " , " + bankDB.getLocation().getCity() +
                " , " + bankDB.getLocation().getStreet() + " " + bankDB.getLocation().getStreetNumber());
        Operation operation = new Operation();
        operation.setBankName(bankDB.getName());
        operation.setIDClient(client.getIdClient());
        operation = bankSystem.createOperation(operation);
    }

    public void downloadOperations() {
        try {
            operationList = new OperationService().getAllOperationIByClient(client.getIdClient());
        } catch (SQLInfoException e) {
            log.info("Exception message : " + e.getMessage());
        }
        if (client.getClientType() == ClientType.BANK) {
            Bank bank = (Bank) client;
            operationList.addAll(new OperationService().getAllOperationInOneBank(bank));
        }
    }

    public void showAllOperation() {
        int i = 1;
        log.info("--------------------------------------------------------------------------------------------------");
        log.info("N |Operation|    Bank      |Client| Amount |Currency| Percent |   Issue   |  Return  | Operation |");
        log.info("  |  ID     |    name      |  ID  |        |        |         |   Date    |   Date   |    Type   |");
        if (operationList.isEmpty()) {
            log.info("You haven't operations");
        } else {
            for (Operation op : operationList) {
                log.info("--------------------------------------------------------------------------------------------------");
                log.info(i + ") - " + op.getIDOperation() + "  | " + op.getBankName()
                        + " |   " + op.getIDClient() + "   | " + op.getAmount()
                        + " |   " + op.getCurrency().toString() + "   |   " + op.getPercent()
                        + "   | " + op.getDateIssue() + " | " + op.getDateReturn() + " | "
                        + op.getType().toString() + "|");
                i++;
            }
            log.info("--------------------------------------------------------------------------------------------------");
            log.info("");
        }
    }

    public void deleteOperation() {
        showAllOperation();
        try {
            int n = MyConsole.readInt() - 1;
            operationService.deleteOperation(operationList.get(n));
            operationList.remove(n);
        } catch (SQLInfoException | IndexOutOfBoundsException e) {
            log.error("Exception msg:" + e.getMessage());
        }
    }

    public void deleteAccount() {
        accountService.deleteAccount(account);
    }

    public void deleteClientFromDataBase() {
        deleteFactory.deleteClient(client);
    }
}
