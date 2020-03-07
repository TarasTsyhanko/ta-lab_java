package banksystem.dao.databasedao;

import banksystem.dao.InvestmentDAO;
import banksystem.entity.Bank;
import banksystem.entity.Investment;
import banksystem.config.mysql.MySQLClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static banksystem.config.CrudOperationConstants.*;

public class InvestmentDataBaseDAO implements InvestmentDAO {
    private static Logger log = LogManager.getLogger(InvestmentDataBaseDAO.class);

    @Override
    public List<Investment> getAllInvestment() {
        List<Investment> investmentList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_INVESTMENT)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                investmentList.add(getInvestmentFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return investmentList;
    }

    @Override
    public List<Investment> getAllInvestmentByClient(float IDClient) {
        List<Investment> investmentList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_INVESTMENT_BY_CLIENT)) {
            statement.setFloat(1, IDClient);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                investmentList.add(getInvestmentFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return investmentList;
    }

    @Override
    public List<Investment> getAllInvestmentInBank(@NotNull Bank bank) {
        List<Investment> investmentList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_INVESTMENT_IN_ONE_BANK)) {
            statement.setString(1, bank.getName());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                investmentList.add(getInvestmentFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return investmentList;
    }

    @Override
    public Investment getInvestmentByID(float investmentID) {
        Investment investment = new Investment();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_INVESTMENT_BY_ID)) {
            statement.setFloat(1, investmentID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                investment = getInvestmentFromDB(resultSet);
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return investment;
    }

    @Override
    public void insertInvestment(@NotNull Investment investment) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(INSERT_INVESTMENT)) {
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            statement.executeBatch();
            statement.setFloat(1, investment.getIDOperation());
            statement.setFloat(2, investment.getIDBank());
            statement.setFloat(3, investment.getIDClient());
            statement.setInt(4, investment.getAmount());
            statement.setDouble(5, investment.getPercent());
            statement.setString(6, investment.getCurrency());
            statement.setDate(7, investment.getDateIssue());
            statement.setDate(8, investment.getDateReturn());
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            statement.executeUpdate();
            statement.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void updateInvestment(@NotNull Investment investment) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(UPDATE_INVESTMENT)) {
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            statement.executeBatch();
            statement.setInt(1, investment.getAmount());
            statement.setDouble(2, investment.getPercent());
            statement.setString(3, investment.getCurrency());
            statement.setDate(4, investment.getDateIssue());
            statement.setDate(5, investment.getDateReturn());
            statement.setFloat(6, investment.getIDOperation());
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            statement.executeUpdate();
            statement.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void deleteInvestment(@NotNull Investment investment) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(DELETE_INVESTMENT)) {
            statement.setFloat(1, investment.getIDOperation());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @NotNull
    private Investment getInvestmentFromDB(@NotNull ResultSet resultSet) throws SQLException {
        Investment investment = new Investment();
        investment.setIDOperation(resultSet.getFloat("IDInvestment"));
        investment.setIDBank(resultSet.getFloat("IDBank"));
        investment.setIDClient(resultSet.getFloat("IDClient"));
        investment.setAmount(resultSet.getInt("Amount"));
        investment.setPercent(resultSet.getDouble("Percent"));
        investment.setCurrency(resultSet.getString("Currency"));
        investment.setDateIssue(resultSet.getDate("Date_Issue"));
        investment.setDateReturn(resultSet.getDate("Date_Return"));
        return investment;
    }
}