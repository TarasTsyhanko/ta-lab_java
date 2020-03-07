package banksystem.dao.databasedao;

import banksystem.dao.DepositDAO;
import banksystem.entity.Bank;
import banksystem.entity.Deposit;
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

public class DepositDataBaseDAO implements DepositDAO {
    private static Logger log = LogManager.getLogger(DepositDataBaseDAO.class);

    @Override
    public List<Deposit> getAllDeposit() {
        List<Deposit> depositList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_DEPOSIT)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                depositList.add(getDepositFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return depositList;
    }

    @Override
    public List<Deposit> getAllDepositByClient(float IDClient) {
        List<Deposit> depositList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_DEPOSIT_BY_CLIENT)) {
            statement.setFloat(1, IDClient);
            statement.setFloat(2, IDClient);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                depositList.add(getDepositFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return depositList;
    }

    @Override
    public List<Deposit> getAllDepositInBank(@NotNull Bank bank) {
        List<Deposit> depositList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_DEPOSIT_IN_ONE_BANK)) {
            statement.setString(1, bank.getName());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                depositList.add(getDepositFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return depositList;
    }

    @Override
    public Deposit getDepositByID(float depositID) {
        Deposit deposit = new Deposit();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_DEPOSIT_BY_ID)) {
            statement.setFloat(1, depositID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                deposit = getDepositFromDB(resultSet);
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return deposit;
    }

    @Override
    public void insertDeposit(@NotNull Deposit deposit) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(INSERT_DEPOSIT)) {
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            statement.executeBatch();
            statement.setFloat(1, deposit.getIDOperation());
            statement.setFloat(2, deposit.getIDBank());
            statement.setFloat(3, deposit.getIDClient());
            statement.setInt(4, deposit.getAmount());
            statement.setDouble(5, deposit.getPercent());
            statement.setString(6, deposit.getCurrency());
            statement.setDate(7, deposit.getDateIssue());
            statement.setDate(8, deposit.getDateReturn());
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            statement.executeUpdate();
            statement.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void updateDeposit(@NotNull Deposit deposit) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(UPDATE_DEPOSIT)) {
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            statement.executeBatch();
            statement.setInt(1, deposit.getAmount());
            statement.setDouble(2, deposit.getPercent());
            statement.setString(3, deposit.getCurrency());
            statement.setDate(4, deposit.getDateIssue());
            statement.setDate(5, deposit.getDateReturn());
            statement.setFloat(6, deposit.getIDOperation());
            statement.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            statement.executeUpdate();
            statement.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void deleteDeposit(@NotNull Deposit deposit) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(DELETE_DEPOSIT)) {
            statement.setFloat(1, deposit.getIDOperation());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @NotNull
    private Deposit getDepositFromDB(@NotNull ResultSet resultSet) throws SQLException {
        Deposit deposit = new Deposit();
        deposit.setIDOperation(resultSet.getFloat("IDDeposit"));
        deposit.setIDBank(resultSet.getFloat("IDBank"));
        deposit.setIDClient(resultSet.getFloat("IDClient"));
        deposit.setAmount(resultSet.getInt("Amount"));
        deposit.setPercent(resultSet.getDouble("Percent"));
        deposit.setCurrency(resultSet.getString("Currency"));
        deposit.setDateIssue(resultSet.getDate("Date_Issue"));
        deposit.setDateReturn(resultSet.getDate("Date_Return"));
        return deposit;
    }
}
