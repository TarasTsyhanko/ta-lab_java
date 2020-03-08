package banksystem.service;

import banksystem.config.exception.InfoException;
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
import java.util.stream.Collectors;

public class InvestmentService {
    InvestmentDAO investmentDAO;
    BankDAO bankDAO;
    PersonDAO personDAO;

    public InvestmentService() {
        investmentDAO = new InvestmentDataBaseDAO();
        bankDAO = new BankDataBaseDAO();
        personDAO = new PersonDataBaseDAO();
    }

    public List<Investment> getAllInvestment() {
        return investmentDAO.getAllInvestment();
    }

    public List<Investment> getAllInvestmentInOneBank(@NotNull Bank bank) {
        if (bankDAO.isBankExists(bank.getName())) {
            return investmentDAO.getAllInvestmentInBank(bank);
        }
        return new ArrayList<>();
    }

    public Investment insertInvestment(Investment investment) throws InfoException {
        if (investment.getIDBank() == investment.getIDClient()) {
            throw new InfoException("Incorrect investment");
        }
        investmentDAO.insertInvestment(investment);
        List<Investment> L = investmentDAO.getAllInvestmentByClient(investment.getIDClient())
                .stream().filter(investment1 -> investment1.hashCode() == investment.hashCode())
                .collect(Collectors.toList());
        return L.get(0);
    }

    public Investment updateInvestment(Investment investment) throws InfoException {
        Investment investmentDB = investmentDAO.getInvestmentByID(investment.getIDOperation());
        if (investmentDB.getIDBank() == investment.getIDBank() && investmentDB.getIDClient() == investment.getIDClient()) {
            investmentDAO.updateInvestment(investment);
        } else throw new InfoException("You can't change Bank or Client");
        return investmentDAO.getInvestmentByID(investment.getIDOperation());
    }

    public List<Investment> getAllInvestmentByClient(int IDClient) {
        return investmentDAO.getAllInvestmentByClient(IDClient);
    }

    public void deleteInvestment(Investment investment) {
        investmentDAO.deleteInvestment(investment);
    }


}
