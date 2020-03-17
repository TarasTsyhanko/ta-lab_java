package banksystem.dao;

import banksystem.entity.Bank;
import banksystem.entity.Location;

import java.util.List;

public interface BankDAO {
    List<Bank> getAllBanks();
    Bank getBankByName( String bankName);
    Bank getBankByLocation(Location location);
    public Bank getBankByID(int IdBank);
    void insertBank(Bank bank);
    void updateBank(Bank bank);
    void deleteBank(Bank bank);
    public boolean isBankExists(String name);
}
