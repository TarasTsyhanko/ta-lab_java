package banksystem.service;

import banksystem.dao.BankDAO;
import banksystem.dao.InvestmentDAO;
import banksystem.dao.PersonDAO;
import banksystem.dao.databasedao.BankDataBaseDAO;
import banksystem.dao.databasedao.InvestmentDataBaseDAO;
import banksystem.dao.databasedao.PersonDataBaseDAO;
import banksystem.entity.Bank;
import banksystem.entity.Investment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InvestmentService {
    InvestmentDAO investmentDAO;
    BankDAO bankDAO;
    PersonDAO personDAO;

    public InvestmentService() {
        investmentDAO = new InvestmentDataBaseDAO();
        bankDAO =new BankDataBaseDAO();
        personDAO = new PersonDataBaseDAO();
    }

    public List<Investment> getAllInvestment(){
        return investmentDAO.getAllInvestment();
    }
    public List<Investment> getAllInvestmentInOneBank(@NotNull Bank bank){
        if (bankDAO.isBankExists(bank.getName())){
            return investmentDAO.getAllInvestmentInBank(bank);
        }
        return new ArrayList<>();
    }
    public List<Investment> getAllInvestmentByClient(int IDClient) {
        return investmentDAO.getAllInvestmentByClient(IDClient);
    }
    public void deleteInvestment(Investment investment){
        investmentDAO.deleteInvestment(investment);
    }


}
