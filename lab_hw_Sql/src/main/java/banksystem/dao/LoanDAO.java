package banksystem.dao;

import banksystem.entity.Bank;
import banksystem.entity.Loan;

import java.util.List;

public interface LoanDAO {
    List<Loan> getAllLoan();
    List<Loan> getAllLoanByClient(float IDClient);
    List<Loan> getAllLoanInBank(Bank bank);
    Loan getLoanByID( float loanID);
    void insertLoan(Loan loan);
    void updateLoan(Loan loan);
    void deleteLoan(Loan loan);
    public boolean isClientHasAlreadyLoan(float IDClient, float IDBank);
}
