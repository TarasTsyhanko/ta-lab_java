package banksystem.service;

import banksystem.dao.BankDAO;
import banksystem.dao.DepositDAO;
import banksystem.dao.PersonDAO;
import banksystem.dao.databasedao.BankDataBaseDAO;
import banksystem.dao.databasedao.DepositDataBaseDAO;
import banksystem.dao.databasedao.PersonDataBaseDAO;
import banksystem.entity.Bank;
import banksystem.entity.Deposit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DepositService {
    DepositDAO depositDAO;
    BankDAO bankDAO;
    PersonDAO personDAO;

    public DepositService() {
        depositDAO = new DepositDataBaseDAO();
        bankDAO =new BankDataBaseDAO();
        personDAO = new PersonDataBaseDAO();
    }
    public List<Deposit> getAllDeposit(){
        return depositDAO.getAllDeposit();
    }
    public List<Deposit> getAllDepositInOneBank(@NotNull Bank bank){
        if(bankDAO.isBankExists(bank.getName())) {
            return depositDAO.getAllDepositInBank(bank);
        }
        return new ArrayList<>();
    }
    public List<Deposit> getAllDepositByClient(int IDClient){
        return depositDAO.getAllDepositByClient(IDClient);
    }
    public void insertDeposit(Deposit deposit){
        depositDAO.insertDeposit(deposit);
    }
    public void deleteDeposit(Deposit deposit){
        depositDAO.deleteDeposit(deposit);
    }
}
