package com.epam.sql.banksystem.dao;

public interface ClientAccountDAO<T> {
    void deleteAccount(T t);

    void updateAccount(T t);

    void insertAccount(T t);

    T openAccountByLoginAndParole(int login, String parole);

    T getAccountByIDClient(int IdClient);
}
