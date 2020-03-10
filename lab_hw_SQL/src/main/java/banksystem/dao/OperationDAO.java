package banksystem.dao;

import banksystem.entity.Operation;

import java.util.List;

public interface OperationDAO {
    List<Operation> getAllOperation();

    Operation getOperationByID(int loanID);

    void insertOperation(Operation operation);

    void updateOperation(Operation operation);

    void deleteOperation(Operation operation);

    boolean isClientHasAlreadyLoan(Operation operation);
}
