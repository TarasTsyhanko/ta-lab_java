package com.epam.sql.banksystem.service;

import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.dao.ClientAccountDAO;
import com.epam.sql.banksystem.dao.databasedao.ClientAccountDataBaseDAO;
import com.epam.sql.banksystem.entity.ClientAccount;
import com.epam.sql.banksystem.entity.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClientAccountService {
    private static Logger log = LogManager.getLogger(ClientAccountService.class);
    private ClientAccountDAO clientAccountDAO;
    private OperationService operationService;

    public ClientAccountService() {
        clientAccountDAO = new ClientAccountDataBaseDAO();
        operationService = new OperationService();
    }

    public ClientAccount insertAccount(ClientAccount account) {
        clientAccountDAO.insertAccount(account);
        return clientAccountDAO.getAccountByIDClient(account.getIDClient());
    }

    public ClientAccount openAccount(int login, String parole) throws InfoException {
        ClientAccount account = clientAccountDAO.openAccountByLoginAndParole(login, parole);
        if (account.getLogin() != login) {
            throw new InfoException("Parole or login are bad, try again");
        }
        return account;
    }

    public ClientAccount updateAccount(ClientAccount account) {
        clientAccountDAO.updateAccount(account);
        return clientAccountDAO.getAccountByIDClient(account.getIDClient());
    }

    public void deleteAccount(ClientAccount account)  {
        List<Operation> operationList = null;
        try {
            operationList = new OperationService().getAllOperationIByClient(account.getIDClient());
        } catch (InfoException e) {
            log.error("Exception msg :"+e.getMessage());
        }
        if(operationList!=null){
            operationList.forEach(operation -> {
                try {
                    operationService.deleteOperation(operation);
                } catch (InfoException e) {
                    log.error("Exception msg :"+e.getMessage());
                }
            });
        }
        clientAccountDAO.deleteAccount(account);
    }
}
