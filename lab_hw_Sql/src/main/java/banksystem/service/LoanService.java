package banksystem.service;

import banksystem.config.exception.InfoException;
import banksystem.dao.BankDAO;
import banksystem.dao.LoanDAO;
import banksystem.dao.PersonDAO;
import banksystem.dao.databasedao.BankDataBaseDAO;
import banksystem.dao.databasedao.LoanDataBaseDAO;
import banksystem.dao.databasedao.PersonDataBaseDAO;
import banksystem.entity.Bank;
import banksystem.entity.Loan;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LoanService {
    LoanDAO loanDAO;
    BankDAO bankDAO;
    PersonDAO personDAO;

    public LoanService() {
        loanDAO = new LoanDataBaseDAO();
        bankDAO =new BankDataBaseDAO();
        personDAO = new PersonDataBaseDAO();
    }

    public List<Loan> getAllLoan(){
        return loanDAO.getAllLoan();
    }
    public List<Loan> getAllLoanInOneBank(@NotNull Bank bank){
        if(bankDAO.isBankExists(bank.getName())) {
            return loanDAO.getAllLoanInBank(bank);
        }
        return new ArrayList<>();
    }
    public List<Loan> getAllLoanIByClient(float IDClient){
        return loanDAO.getAllLoanByClient(IDClient);
    }

    public void insertLoan(@NotNull Loan loan) throws InfoException {
        if(loan.getIDBank()==loan.getIDClient()){
            throw new InfoException("");
        }
        if(!loanDAO.isClientHasAlreadyLoan(loan.getIDClient(),loan.getIDBank())){
            loanDAO.insertLoan(loan);
        }else {
            throw new InfoException("This Client already has LOAN in this Bank");
        }
    }

}
