package banksystem.dao.databasedao;

import banksystem.config.mysql.MySQL;
import banksystem.dao.ClientAccountDAO;
import banksystem.entity.ClientAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static banksystem.config.CrudOperationConstants.*;

public class ClientAccountDataBaseDAO implements ClientAccountDAO {
    private static Logger log = LogManager.getLogger(BankDataBaseDAO.class);

    public ClientAccount getAccountByIDClient(int IdClient) {
        ClientAccount account = new ClientAccount();
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(SELECT_ACCOUNT_BY_ID_CLIENT)) {
            ps.setInt(1, IdClient);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    account.setLogin(rs.getInt("Login"));
                    account.setParole(rs.getString("Parole"));
                    account.setIDClient(rs.getInt("IDClient"));
                }
            }
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
        return account;
    }

    public ClientAccount openAccountByLoginAndParole(int login, String parole) {
        ClientAccount account = new ClientAccount();
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(SELECT_ACCOUNT_BY_PAROLE_LOGIN)) {
            ps.setInt(1, login);
            ps.setString(2, parole);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    account.setLogin(rs.getInt("Login"));
                    account.setParole(rs.getString("Parole"));
                    account.setIDClient(rs.getInt("IDClient"));
                }
            }
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
        return account;
    }

    public void insertAccount(@NotNull ClientAccount account) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(INSERT_ACCOUNT)) {
            ps.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            ps.executeBatch();
            ps.setString(1, account.getParole());
            ps.setInt(2, account.getIDClient());
            ps.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            ps.executeUpdate();
            ps.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }


    public void updateAccount(@NotNull ClientAccount account) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(UPDATE_ACCOUNT)) {
            ps.setString(1, account.getParole());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }


    public void deleteAccount(@NotNull ClientAccount account) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(DELETE_ACCOUNT)) {
            ps.setInt(1, account.getLogin());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }
}
