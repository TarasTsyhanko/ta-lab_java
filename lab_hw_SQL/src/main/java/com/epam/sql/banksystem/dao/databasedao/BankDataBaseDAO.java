package com.epam.sql.banksystem.dao.databasedao;

import com.epam.sql.banksystem.config.mysql.MySQL;
import com.epam.sql.banksystem.dao.BankDAO;
import com.epam.sql.banksystem.entity.Location;
import com.epam.sql.banksystem.entity.Bank;
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

import static com.epam.sql.banksystem.config.CrudOperationConstants.*;

public class BankDataBaseDAO implements BankDAO<Bank> {
    private static Logger log = LogManager.getLogger(BankDataBaseDAO.class);
    @Override
    public List<Bank> getAllBanks() {
        List<Bank> banks = new ArrayList<>();
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(SELECT_ALL_BANKS)) {
            try(ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                Bank bank = new Bank();
                Location location = new Location();
                bank.setId(rs.getInt("IDBank"));
                bank.setName(rs.getString("BankName"));
                location.setCountry(rs.getString("Country"));
                location.setCity(rs.getString("City"));
                location.setStreet(rs.getString("Street"));
                location.setStreetNumber(rs.getInt("StreetNumber"));
                bank.setLocation(location);
                banks.add(bank);
            }}
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
        return banks;
    }

    @Override
    public void insertBank(@NotNull Bank bank) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(INSERT_BANK)) {
            ps.setString(1, bank.getName());
            ps.setString(2, bank.getLocation().getCountry());
            ps.setString(3, bank.getLocation().getCity());
            ps.setString(4, bank.getLocation().getStreet());
            ps.setInt(5, bank.getLocation().getStreetNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    @Override
    public void updateBank(@NotNull Bank bank) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(UPDATE_BANK)){
            ps.setString(1, bank.getName());
            ps.setString(2, bank.getLocation().getCountry());
            ps.setString(3, bank.getLocation().getCity());
            ps.setString(4, bank.getLocation().getStreet());
            ps.setInt(5, bank.getLocation().getStreetNumber());
            ps.setInt(6, bank.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    @Override
    public void deleteBank(@NotNull Bank bank) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(DELETE_BANK)){
            ps.setInt(1,bank.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    public boolean isBankExists(String name) {
        String msg = "";
        try (CallableStatement statement = MySQL.getConnection().prepareCall("{call InsertBank(?)}")) {
            statement.setString("BankNameIn", name);
            try(ResultSet rs = statement.executeQuery()){
            while (rs.next()) {
                msg = rs.getString(1);
            }
            if(msg.equals("This bank already exists")){
                return true;
            }}
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        return false;
    }
}