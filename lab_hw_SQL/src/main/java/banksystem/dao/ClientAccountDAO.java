package banksystem.dao;

import banksystem.entity.ClientAccount;

public interface ClientAccountDAO {
    void deleteAccount(ClientAccount account);

    void updateAccount(ClientAccount account);

    void insertAccount(ClientAccount account);

    ClientAccount openAccountByLoginAndParole(int login, String parole);

    ClientAccount getAccountByIDClient(int IdClient);
}
