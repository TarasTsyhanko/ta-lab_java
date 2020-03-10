package banksystem.service;

import banksystem.config.exception.InfoException;
import banksystem.dao.*;
import banksystem.dao.databasedao.*;
import banksystem.entity.*;
import client.Bank;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BankService {
    private BankDAO bankDAO;
    private OperationDAO operationDAO;

    public BankService() {
        bankDAO = new BankDataBaseDAO();
        operationDAO = new OperationDataBaseDAO();
    }

    public Bank getBankByName(String name) throws InfoException {
        if (bankDAO.isBankExists(name)) {
            return bankDAO.getBankByName(name);
        } else {
            throw new InfoException("This bank is absent");
        }
    }

    public Bank getBankById(int id) {
        return bankDAO.getBankByID(id);

    }

    public List<Bank> getAllBanks() {
        return bankDAO.getAllBanks();
    }

    public Bank insertBank(@NotNull Bank bank) throws InfoException {
        if (!(bankDAO.isBankExists(bank.getName()))) {
            bankDAO.insertBank(bank);
            return bankDAO.getBankByName(bank.getName());
        } else {
            throw new InfoException("This bank already exists");
        }
    }

    public Bank updateBank(Bank bank) throws InfoException {
        OperationService service = new OperationService();
        Bank bankDB = bankDAO.getBankByID(bank.getId());
        if (!bank.getName().equals(bankDB.getName())) {
            if (!bankDAO.isBankExists(bank.getName())) {
                List<Operation> operations = service.getAllOperationInOneBank(bank);
                for (Operation o : operations) {
                    o.setBankName(bank.getName());
                    service.updateOperation(o);
                }
                bankDAO.updateBank(bank);
            }
        } else if (bank.getName().equals(bankDB.getName())) {
            bankDAO.updateBank(bank);
        }
        return bankDAO.getBankByName(bank.getName());
    }


    public void deleteBank(@NotNull Bank bank) throws InfoException {
        if (bankDAO.isBankExists(bank.getName())) {
            List<Operation> loanList = new OperationService().getAllOperationIByClient(bank.getIdClient());
            if (!loanList.isEmpty()) {
                loanList.forEach(loan -> operationDAO.deleteOperation(loan));
            }
            loanList = new OperationService().getAllOperationInOneBank(bank);
            if (!loanList.isEmpty()) {
                loanList.forEach(operation -> operationDAO.deleteOperation(operation));
            }
            bankDAO.deleteBank(bank);
        } else {
            throw new InfoException("This bank is absent");
        }
    }
}
