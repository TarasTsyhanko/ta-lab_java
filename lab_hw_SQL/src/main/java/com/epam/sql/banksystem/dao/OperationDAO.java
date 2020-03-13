package com.epam.sql.banksystem.dao;

import java.util.List;

public interface OperationDAO<T> {
    List<T> getAllOperation();

    T getOperationByID(int loanID);

    void insertOperation(T t);

    void updateOperation(T t);

    void deleteOperation(T t);

    boolean isClientHasAlreadyLoan(T t);
}
