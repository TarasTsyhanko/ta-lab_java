package com.epam.sql.banksystem.dao;

import java.util.List;

public interface BankDAO<T> {
    List<T> getAllBanks();

    void insertBank(T t);

    void updateBank(T t);

    void deleteBank(T t);

    boolean isBankExists(String name);
}
