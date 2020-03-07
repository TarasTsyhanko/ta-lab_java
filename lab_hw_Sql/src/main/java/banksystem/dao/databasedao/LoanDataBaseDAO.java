package banksystem.dao.databasedao;

import banksystem.dao.LoanDAO;
import banksystem.entity.Bank;
import banksystem.entity.Loan;
import banksystem.config.mysql.MySQLClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static banksystem.config.CrudOperationConstants.*;

public class LoanDataBaseDAO implements LoanDAO {
    private static Logger log = LogManager.getLogger(LoanDataBaseDAO.class);

    @Override
    public List<Loan> getAllLoan() {
        List<Loan> loanList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_LOAN)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                loanList.add(getLoanFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return loanList;
    }

    @Override
    public List<Loan> getAllLoanByClient(float IDClient) {
        List<Loan> loanList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_LOAN_BY_CLIENT)) {
            statement.setFloat(1, IDClient);
            statement.setFloat(2, IDClient);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                loanList.add(getLoanFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        MySQLClient.closeConnection();
        return loanList;
    }

    @Override
    public List<Loan> getAllLoanInBank(@NotNull Bank bank) {
        List<Loan> loanList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_LOAN_IN_ONE_BANK)) {
            statement.setString(1, bank.getName());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                loanList.add(getLoanFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return loanList;
    }

    @Override
    public Loan getLoanByID(float loanID) {
        Loan loan = new Loan();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_LOAN_BY_ID)) {
            statement.setFloat(1, loanID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                loan = getLoanFromDB(resultSet);
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return loan;
    }

    @Override
    public void insertLoan(@NotNull Loan loan) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(INSERT_LOAN)) {
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            statement.executeBatch();
            statement.setFloat(1, loan.getIDOperation());
            statement.setFloat(2, loan.getIDBank());
            statement.setFloat(3, loan.getIDClient());
            statement.setInt(4, loan.getAmount());
            statement.setDouble(5, loan.getPercent());
            statement.setString(6,loan.getCurrency());
            statement.setDate(7,loan.getDateIssue());
            statement.setDate(8,loan.getDateReturn());
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            statement.executeUpdate();
            statement.executeBatch();
        } catch (SQLException e) {
            log.error( "SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void updateLoan(@NotNull Loan loan) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(UPDATE_LOAN)) {
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            statement.executeBatch();
            statement.setInt(1, loan.getAmount());
            statement.setDouble(2, loan.getPercent());
            statement.setString(3,loan.getCurrency());
            statement.setDate(4,loan.getDateIssue());
            statement.setDate(5,loan.getDateReturn());
            statement.setFloat(6, loan.getIDOperation());
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            statement.executeUpdate();
            statement.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void deleteLoan(@NotNull Loan loan) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(DELETE_LOAN)){
            statement.setFloat(1,loan.getIDOperation());
            statement.executeUpdate();
        }catch (SQLException e){
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }
    @NotNull
    private Loan getLoanFromDB(@NotNull ResultSet resultSet) throws SQLException {
        Loan loan = new Loan();
        loan.setIDOperation(resultSet.getInt("IDLoan"));
        loan.setIDBank(resultSet.getInt("IDBank"));
        loan.setIDClient(resultSet.getInt("IDClient"));
        loan.setAmount(resultSet.getInt("Amount"));
        loan.setPercent(resultSet.getDouble("Percent"));
        loan.setCurrency(resultSet.getString("Currency"));
        loan.setDateIssue(resultSet.getDate("Date_Issue"));
        loan.setDateReturn(resultSet.getDate("Date_Return"));
        return loan;
    }
     public boolean isClientHasAlreadyLoan(float IDClient, float IDBank){
         String msg ="";
         try (CallableStatement statement = MySQLClient.getConnection().prepareCall("{call TakeLoan(?)}")) {
             statement.setFloat("IDClientIN", IDClient);
             statement.setFloat("IDBankIN", IDBank);
             ResultSet rs = statement.executeQuery();
             while (rs.next()) {
                 msg = rs.getString(1);
             }
             if(msg.equals("This Client already has LOAN in this Bank")){
                 log.error("This Client already has LOAN in this Bank"+ " IDClient: "+IDClient);
                 return true;
             }
         } catch (SQLException e) {
             log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
             e.printStackTrace();
         }
         return false;
     }
}
