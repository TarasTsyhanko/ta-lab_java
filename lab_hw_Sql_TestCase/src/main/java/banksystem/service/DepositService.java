package banksystem.service;

import banksystem.config.exception.InfoException;
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
import java.util.stream.Collectors;

public class DepositService {
    DepositDAO depositDAO;
    BankDAO bankDAO;
    PersonDAO personDAO;

    public DepositService() {
        depositDAO = new DepositDataBaseDAO();
        bankDAO = new BankDataBaseDAO();
        personDAO = new PersonDataBaseDAO();
    }

    public List<Deposit> getAllDeposit() {
        return depositDAO.getAllDeposit();
    }

    public List<Deposit> getAllDepositInOneBank(@NotNull Bank bank) {
        if (bankDAO.isBankExists(bank.getName())) {
            return depositDAO.getAllDepositInBank(bank);
        }
        return new ArrayList<>();
    }
    public Deposit updateDeposit(Deposit deposit) throws InfoException {
        Deposit depositDB = depositDAO.getDepositByID(deposit.getIDOperation());
        if(depositDB.getIDBank()==deposit.getIDBank()&&depositDB.getIDClient()==deposit.getIDClient()){
            depositDAO.updateDeposit(deposit);
        }else  throw new InfoException("You can't change Bank or Client");
        return depositDAO.getDepositByID(deposit.getIDOperation());
    }

    public List<Deposit> getAllDepositByClient(int IDClient) {
        return depositDAO.getAllDepositByClient(IDClient);
    }

    public Deposit insertDeposit(Deposit deposit) throws InfoException {
        if(deposit.getIDBank()==deposit.getIDClient()){
            throw new InfoException("Incorrect deposit");
        }
        depositDAO.insertDeposit(deposit);
        List<Deposit> L = depositDAO.getAllDepositByClient(deposit.getIDClient())
                .stream().filter(deposit1 -> deposit1.hashCode() == deposit.hashCode())
                .collect(Collectors.toList());
        return L.get(0);
    }

    public void deleteDeposit(Deposit deposit) {
        depositDAO.deleteDeposit(deposit);
    }
}
