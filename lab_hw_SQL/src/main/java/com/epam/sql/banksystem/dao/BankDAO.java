package com.epam.sql.banksystem.dao;

import com.epam.sql.banksystem.entity.Bank;

import java.util.List;

public interface BankDAO {
    List<Bank> getAllBanks();

    void insertBank(Bank bank);

    void updateBank(Bank bank);

    void deleteBank(Bank bank);

    boolean isBankExists(String name);
}
