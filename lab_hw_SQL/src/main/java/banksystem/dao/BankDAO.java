package banksystem.dao;

import client.Bank;

import java.util.List;

public interface BankDAO {
    List<Bank> getAllBanks();

    Bank getBankByName(String bankName);

    Bank getBankByID(int IdBank);

    void insertBank(Bank bank);

    void updateBank(Bank bank);

    void deleteBank(Bank bank);

    boolean isBankExists(String name);
}
