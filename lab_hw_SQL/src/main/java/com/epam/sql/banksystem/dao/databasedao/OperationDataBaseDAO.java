package com.epam.sql.banksystem.dao.databasedao;

import com.epam.sql.banksystem.config.mysql.MySQL;
import com.epam.sql.banksystem.dao.OperationDAO;
import com.epam.sql.banksystem.entity.Operation;
import com.epam.sql.app.enums.Current;
import com.epam.sql.app.enums.OperationType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.sql.banksystem.config.CrudOperationConstants.*;

public class OperationDataBaseDAO implements OperationDAO {
    private static Logger log = LogManager.getLogger(OperationDataBaseDAO.class);

    @Override
    public List<Operation> getAllOperation() {
        List<Operation> operationList = new ArrayList<>();
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(SELECT_ALL_OPERATION)) {
            try(ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                operationList.add(getOperationFromDB(rs));
            }}
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
        return operationList;
    }


    @Override
    public Operation getOperationByID(int operate) {
        Operation operation = new Operation();
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(SELECT_OPERATION_BY_ID)) {
            ps.setInt(1, operate);
            try(ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                operation = getOperationFromDB(rs);
            }}
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
        return operation;
    }

    @Override
    public void insertOperation(@NotNull Operation operation) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(INSERT_OPERATION)) {
            ps.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            ps.executeBatch();
            ps.setString(1, operation.getBankName());
            ps.setInt(2, operation.getIDClient());
            ps.setInt(3, operation.getAmount());
            ps.setDouble(4, operation.getPercent());
            ps.setString(5,operation.getCurrency().toString());
            ps.setDate(6,operation.getDateIssue());
            ps.setDate(7,operation.getDateReturn());
            ps.setString(8,operation.getType().toString());
            ps.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            ps.executeUpdate();
            ps.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    @Override
    public void updateOperation(@NotNull Operation operation) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(UPDATE_OPERATION)) {
            ps.addBatch(SET_FOREIGN_KEY_CHECKS+"0");
            ps.executeBatch();
            ps.setString(1,operation.getBankName());
            ps.setInt(2, operation.getAmount());
            ps.setDouble(3, operation.getPercent());
            ps.setString(4,operation.getCurrency().toString());
            ps.setDate(5,operation.getDateIssue());
            ps.setDate(6,operation.getDateReturn());
            ps.setInt(7, operation.getIDOperation());
            ps.addBatch(SET_FOREIGN_KEY_CHECKS+"1");
            ps.executeUpdate();
            ps.executeBatch();
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    @Override
    public void deleteOperation(@NotNull Operation operation) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(DELETE_OPERATION)){
            ps.setInt(1,operation.getIDOperation());
            ps.executeUpdate();
        }catch (SQLException e){
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }
    @NotNull
    private Operation getOperationFromDB(@NotNull ResultSet resultSet) throws SQLException {
        Operation operation = new Operation();
        operation.setIDOperation(resultSet.getInt("IDOperation"));
        operation.setBankName(resultSet.getString("BankName"));
        operation.setIDClient(resultSet.getInt("IDClient"));
        operation.setAmount(resultSet.getInt("Amount"));
        operation.setPercent(resultSet.getDouble("Percent"));
        operation.setCurrency(Current.valueOf(resultSet.getString("Currency")));
        operation.setDateIssue(resultSet.getDate("Date_Issue"));
        operation.setDateReturn(resultSet.getDate("Date_Return"));
        operation.setType(OperationType.valueOf(resultSet.getString("TypeOperation")));
        return operation;
    }
     public boolean isClientHasAlreadyLoan(Operation operation){
         String msg ="";
         try (CallableStatement ps = MySQL.getConnection().prepareCall("{call TakeLoan(?,?,?)}")) {
             ps.setInt("IDClientIN", operation.getIDClient());
             ps.setString("BankNameIN", operation.getBankName());
             ps.setString("TypeIN", operation.getType().toString());
             try(ResultSet rs = ps.executeQuery()){
             while (rs.next()) {
                 msg = rs.getString(1);
             }
             if(msg.equals("This Client already has LOAN in this Bank")){
                 log.error(msg+ " IDClient: "+operation.getIDClient());
                 return true;
             }}
         } catch (SQLException e) {
             log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
         }
         return false;
     }
}
