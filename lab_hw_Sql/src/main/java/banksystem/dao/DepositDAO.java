package banksystem.dao;

import banksystem.entity.Bank;
import banksystem.entity.Deposit;

import java.util.List;

public interface DepositDAO {
    List<Deposit> getAllDeposit();
    List<Deposit> getAllDepositByClient(float IDClient);
    List<Deposit> getAllDepositInBank(Bank bank);
    Deposit getDepositByID( float depositID);
    void insertDeposit(Deposit deposit);
    void updateDeposit(Deposit deposit);
    void deleteDeposit(Deposit deposit);
}
