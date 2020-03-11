package com.epam.sql.banksystem.config;

public class CrudOperationConstants {
    public static final String SELECT_ALL_BANKS = "SELECT * FROM Bank";
    public static final String INSERT_BANK = "INSERT INTO Bank ( BankName, Country,City, Street, StreetNumber) VALUE(?,?,?,?,?)";
    public static final String UPDATE_BANK = "UPDATE Bank SET BankName=?, Country=?,City=?,Street=?,StreetNumber=? WHERE IDBank=?";
    public static final String DELETE_BANK = "DELETE FROM Bank WHERE IDBank=?";

    public static final String SELECT_ALL_PERSONS = "SELECT * FROM Person";
    public static final String SELECT_PERSON_BY_FIRST_NAME = "SELECT * FROM Person WHERE FirstName=? AND LastName=?";
    public static final String INSERT_PERSON = "INSERT INTO Person (IDPerson,FirstName,LastName,Age,Country,Email) VALUE(?,?,?,?,?,?)";
    public static final String UPDATE_PERSON = "UPDATE Person SET FirstName=?, LastName=?,Age=?, Country=?,Email=? WHERE IDPerson=?";
    public static final String DELETE_PERSON = "DELETE FROM Person WHERE IDPerson=?";

    public static final String SELECT_ACCOUNT_BY_PAROLE_LOGIN = "SELECT * FROM ClientAccount WHERE Login=? AND Parole=?";
    public static final String SELECT_ACCOUNT_BY_ID_CLIENT = "SELECT * FROM ClientAccount WHERE IDClient=?";
    public static final String INSERT_ACCOUNT = "INSERT INTO ClientAccount (Parole, IDClient) VALUE(?,?)";
    public static final String UPDATE_ACCOUNT = "UPDATE ClientAccount SET Parole=? WHERE IDClient=?";
    public static final String DELETE_ACCOUNT = "DELETE FROM ClientAccount WHERE IDClient=?";

    public static final String SELECT_ALL_OPERATION = "SELECT * FROM Operation";
    public static final String SELECT_OPERATION_BY_ID="SELECT * FROM Operation WHERE IDOperation=?";
    public static final String INSERT_OPERATION= "INSERT INTO Operation (BankName,IDClient,Amount,Percent,Currency,Date_Issue,Date_Return,TypeOperation) VALUE(?,?,?,?,?,?,?,?)";
    public static final String UPDATE_OPERATION= "UPDATE Operation SET BankName=?,Amount=?,Percent=?,Currency=?,Date_Issue=?,Date_Return=? WHERE IDOperation=?";
    public static final String DELETE_OPERATION= "DELETE FROM Operation WHERE IDOperation=?";

    public static final String SET_FOREIGN_KEY_CHECKS = "SET FOREIGN_KEY_CHECKS =";



}
