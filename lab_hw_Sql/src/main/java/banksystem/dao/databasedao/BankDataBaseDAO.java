package banksystem.dao.databasedao;

import banksystem.dao.BankDAO;
import banksystem.entity.Bank;
import banksystem.entity.Location;
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

public class BankDataBaseDAO implements BankDAO {
    private static Logger log = LogManager.getLogger(BankDataBaseDAO.class);
    @Override
    public List<Bank> getAllBanks() {
        List<Bank> banks = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_BANKS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Bank bank = new Bank();
                bank.setId(resultSet.getFloat("IDBank"));
                bank.setName(resultSet.getString("BankName"));
                bank.setIDLocation(resultSet.getInt("IDLocation"));
                banks.add(bank);
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return banks;
    }

    @Override
    public Bank getBankByName(String bankName) {
        Bank bank = new Bank();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_BANK_BY_NAME)) {
            statement.setString(1,bankName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bank.setId(resultSet.getFloat("IDBank"));
                bank.setName(resultSet.getString("BankName"));
                bank.setIDLocation(resultSet.getInt("IDLocation"));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return bank;
    }
    @Override
    public Bank getBankByID(float IdBank) {
        Bank bank = new Bank();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_BANK_BY_ID)) {
            statement.setFloat(1,IdBank);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bank.setId(resultSet.getFloat("IDBank"));
                bank.setName(resultSet.getString("BankName"));
                bank.setIDLocation(resultSet.getInt("IDLocation"));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return bank;
    }

    public Bank getBankByLocation(@NotNull Location location) {
        Bank bank = new Bank();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_BANK_BY_LOCATION)) {
            statement.setFloat(1,location.getLocationID());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bank.setId(resultSet.getFloat("IDBank"));
                bank.setName(resultSet.getString("BankName"));
                bank.setIDLocation(resultSet.getInt("IDLocation"));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return bank;
    }

    @Override
    public void insertBank(@NotNull Bank bank) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(INSERT_BANK)) {
            statement.setString(1, bank.getName());
            statement.setFloat(2, bank.getIDLocation());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void updateBank(@NotNull Bank bank) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(UPDATE_BANK)){
            statement.setString(1,bank.getName());
            statement.setFloat(2,bank.getIDLocation());
            statement.setFloat(3,bank.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void deleteBank(@NotNull Bank bank) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(DELETE_BANK)){
            statement.setFloat(1,bank.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    public boolean isBankExists(String name) {
        String msg = "";
        try (CallableStatement statement = MySQLClient.getConnection().prepareCall("{call InsertBank(?)}")) {
            statement.setString("BankNameIn", name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                msg = rs.getString(1);
            }
            if(msg.equals("This bank already exists")){
                return true;
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        return false;
    }
}
