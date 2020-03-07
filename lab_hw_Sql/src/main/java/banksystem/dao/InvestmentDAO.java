package banksystem.dao;

import banksystem.entity.Bank;
import banksystem.entity.Investment;

import java.util.List;

public interface InvestmentDAO {
    List<Investment> getAllInvestment();
    List<Investment> getAllInvestmentByClient(float IDClient);
    List<Investment> getAllInvestmentInBank(Bank bank);
    Investment getInvestmentByID( float investmentID);
    void insertInvestment(Investment investment);
    void updateInvestment(Investment investment);
    void deleteInvestment(Investment investment);
}
