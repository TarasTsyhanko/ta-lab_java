package banksystem.service;

import banksystem.config.exception.InfoException;
import banksystem.dao.ClientAccountDAO;
import banksystem.dao.databasedao.ClientAccountDataBaseDAO;
import banksystem.entity.ClientAccount;

public class ClientAccountService {
    private ClientAccountDAO clientAccountDAO;

    public ClientAccountService() {
        clientAccountDAO = new ClientAccountDataBaseDAO();
    }

    public ClientAccount insertAccount (ClientAccount account){
        clientAccountDAO.insertAccount(account);
        return clientAccountDAO.getAccountByIDClient(account.getIDClient());
    }
    public ClientAccount openAccount(int login, String parole) throws InfoException {
         ClientAccount account = clientAccountDAO.openAccountByLoginAndParole(login,parole);
         if(account.getLogin()!=login){
             throw new InfoException("Parole or login are bad, try again");
         }
         return account;
    }
}
