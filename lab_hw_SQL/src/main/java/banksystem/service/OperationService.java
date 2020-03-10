package banksystem.service;

import banksystem.config.exception.InfoException;
import banksystem.dao.BankDAO;
import banksystem.dao.OperationDAO;
import banksystem.dao.PersonDAO;
import banksystem.dao.databasedao.BankDataBaseDAO;
import banksystem.dao.databasedao.OperationDataBaseDAO;
import banksystem.dao.databasedao.PersonDataBaseDAO;
import banksystem.entity.Operation;
import client.Bank;
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
                    .stream().filter(op->op.getBankName().equals(bank.getName()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Operation> getAllOperationIByClient(int IDClient) throws InfoException {
        List<Operation> operationList = operationDAO.getAllOperation()
                .stream().filter(op-> op.getIDClient()==IDClient)
                .collect(Collectors.toList());
        if (operationList.isEmpty()) {
            throw new InfoException("This client has no any loan");
        }
        return operationList;
    }

    public Operation updateOperation(Operation operation) {
        operationDAO.updateOperation(operation);
        return operationDAO.getOperationByID(operation.getIDOperation());
    }

    public Operation getOperationByID(Operation operation) throws InfoException {
        Operation operationDB = operationDAO.getOperationByID(operation.getIDOperation());
        if (operationDB != operation) {
            throw new InfoException("This Loan absent");
        }
        return operation;
    }

    public Operation insertOperation(Operation operation) throws InfoException {
        if (!operationDAO.isClientHasAlreadyLoan(operation)) {
            operationDAO.insertOperation(operation);
            return getAllOperationIByClient(operation.getIDClient())
                    .stream().filter(operation1 -> operation == operation1)
                    .collect(Collectors.toList()).get(0);
        } else throw new InfoException("This Client already has LOAN in this Bank");
    }


    public void deleteOperation(Operation operation) throws InfoException {
        if (getOperationByID(operation) == operation) {
            operationDAO.deleteOperation(operation);
        } else throw new InfoException("This operation absent");
    }

}
