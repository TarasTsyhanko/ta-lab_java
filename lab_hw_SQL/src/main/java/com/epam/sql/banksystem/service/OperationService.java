package com.epam.sql.banksystem.service;

import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.dao.BankDAO;
import com.epam.sql.banksystem.dao.OperationDAO;
import com.epam.sql.banksystem.dao.PersonDAO;
import com.epam.sql.banksystem.dao.databasedao.BankDataBaseDAO;
import com.epam.sql.banksystem.dao.databasedao.OperationDataBaseDAO;
import com.epam.sql.banksystem.dao.databasedao.PersonDataBaseDAO;
import com.epam.sql.banksystem.entity.Operation;
import com.epam.sql.banksystem.entity.Bank;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationService {
    private OperationDAO operationDAO;
    private BankDAO bankDAO;
    private PersonDAO personDAO;

    public OperationService() {
        operationDAO = new OperationDataBaseDAO();
        bankDAO = new BankDataBaseDAO();
        personDAO = new PersonDataBaseDAO();
    }

    public List<Operation> getAllOperation() {
        return operationDAO.getAllOperation();
    }

    public List<Operation> getAllOperationInOneBank(@NotNull Bank bank) {
        if (bankDAO.isBankExists(bank.getName())) {
            return operationDAO.getAllOperation()
                    .stream().filter(op -> op.getBankName().equals(bank.getName()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Operation> getAllOperationIByClient(int IDClient) throws InfoException {
        List<Operation> operationList = operationDAO.getAllOperation()
                .stream().filter(op -> op.getIDClient() == IDClient)
                .collect(Collectors.toList());
        if (operationList.isEmpty()) {
            throw new InfoException("This client has no any operation");
        }
        return operationList;
    }

    public Operation updateOperation(Operation operation) {
        operationDAO.updateOperation(operation);
        return operationDAO.getOperationByID(operation.getIDOperation());
    }

    public Operation getOperationByID(Operation operation) throws InfoException {
        Operation operationDB = operationDAO.getOperationByID(operation.getIDOperation());
        if (operationDB.getIDOperation() != operation.getIDOperation()) {
            throw new InfoException("This Loan absent");
        }
        return operation;
    }

    public Operation insertOperation(Operation operation) throws InfoException {
        if (!operationDAO.isClientHasAlreadyLoan(operation)) {
            operationDAO.insertOperation(operation);
            List<Operation> list = getAllOperationIByClient(operation.getIDClient());
            for (Operation operationDb : list) {
                if (operationDb == operation) {
                    return operationDb;
                }
            }
        } else throw new InfoException("This Client already has LOAN in this Bank");
        return new Operation();
    }


    public void deleteOperation(Operation operation) throws InfoException {
        if (getOperationByID(operation) == operation) {
            operationDAO.deleteOperation(operation);
        } else throw new InfoException("This operation absent");
    }

}
