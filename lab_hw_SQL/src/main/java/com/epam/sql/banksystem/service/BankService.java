package com.epam.sql.banksystem.service;

import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.dao.*;
import com.epam.sql.banksystem.dao.databasedao.*;
import com.epam.sql.banksystem.entity.*;
import com.epam.sql.banksystem.entity.Bank;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class BankService {
    private BankDAO bankDAO;
    private OperationDAO operationDAO;

    public BankService() {
        bankDAO = new BankDataBaseDAO();
        operationDAO = new OperationDataBaseDAO();
    }

    public Bank getBankByName(String name) throws InfoException {
        if (bankDAO.isBankExists(name)) {
            return bankDAO.getAllBanks().stream().filter(bank -> bank.getName().equals(name)).collect(Collectors.toList()).get(0);
        } else {
            throw new InfoException("This bank is absent");
        }
    }

    public Bank getBankById(int id) throws InfoException {
        List<Bank> banks = bankDAO.getAllBanks().stream().filter(bank -> bank.getId() == id).collect(Collectors.toList());
        if(!banks.isEmpty()){
            return banks.get(0);
        }else throw new InfoException("There aren't banks in Data Base");
    }

    public List<Bank> getAllBanks() {
        return bankDAO.getAllBanks();
    }

    public Bank insertBank(@NotNull Bank bank) throws InfoException {
        if (!(bankDAO.isBankExists(bank.getName()))) {
            bankDAO.insertBank(bank);
            return getBankByName(bank.getName());
        } else {
            throw new InfoException("This bank already exists");
        }
    }

    public Bank updateBank(Bank bank) throws InfoException {
        OperationService service = new OperationService();
        Bank bankDB = getBankById(bank.getId());
        if (!bank.getName().equals(bankDB.getName())) {
            if (!bankDAO.isBankExists(bank.getName())) {
                List<Operation> operations = service.getAllOperationInOneBank(bankDB);
                for (Operation o : operations) {
                    o.setBankName(bank.getName());
                    service.updateOperation(o);
                }
                bankDAO.updateBank(bank);
            }
        } else if (bank.getName().equals(bankDB.getName())) {
            bankDAO.updateBank(bank);
        }
        return getBankByName(bank.getName());
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
