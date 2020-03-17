package com.epam.sql.banksystem;

import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.dao.databasedao.BankDataBaseDAO;
import com.epam.sql.banksystem.dao.databasedao.LoanDataBaseDAO;
import com.epam.sql.banksystem.entity.Bank;
import com.epam.sql.banksystem.entity.Loan;
import com.epam.sql.banksystem.service.LoanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class Main {
    private static Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws InfoException {
        List<Bank> bankList = new BankDataBaseDAO().getAllBanks();
        List<Loan> loans = new LoanDataBaseDAO().getAllLoan();
        new LoanService().insertLoan(new Loan(2226,450,440,4,
                4.5,"UAN", Date.valueOf("2020-12-01"),Date.valueOf("2030-02-28")));

    //
    //   List<Location> locationList = new LocationDataBaseDAO().getAllLocations();
    //   Location loc = locationList.get(0);
    //   loc.setStreet("Õurova 3");
    //   new LocationDataBaseDAO().updateLocation(loc);
   //    List<Bank> bankList = new BankDataBaseDAO().getAllBanks();
   //    Bank bank = bankList.get(0);
   //    bank.setName("Wars Bank");
   //  //  bank.setLocationID(344567);
   //   new BankDataBaseDAO().updateBank(bank);

     //  List<Person> personList = new PersonDataBaseDAO().getAllPerson();
     //
     //  KeyDAO keyDAO  = new KeyDAO();
     //  new DepositDataBaseDAO().insertDeposit(new Deposit(5551,bankList.get(0).getId(),
     //          personList.get(0).getId(),3000,19.4,"USD",Date.valueOf("2020-03-05"),Date.valueOf("2025-12-25")));


     //   PersonService personService = new PersonService();
     //   personService.deletePerson(personList.get(0));


     //  BankDAO bankDAO = new BankDataBaseDAO();
     //  DepositDAO depositDAO = new DepositDataBaseDAO();
     //  //List<Bank> bankList = bankDAO.getAllBanks();
     //  List<Person> personList = new PersonDataBaseDAO().getAllPerson();
     //  Person p = new PersonDataBaseDAO().getPersonByName(personList.get(3).getFirstName());
     //      log.info(p.getId()+"  "+p.getFirstName()+"  "+p.getLastName()+"  "+p.getNationality());







      //  for (Bank b :bankList) {
      //      log.info(b.getId()+"  "+b.getName()+"  "+b.getLocationID());
      //  }
      // List<Deposit> depositList = depositDAO.getAllDepositByClient(personList.get(0).getId());
      //  for (Deposit b :depositList) {
      //      log.info(b.getIDOperation()+"  "+b.getIDBank()+"  "+b.getIDClient()
      //              +"  "+b.getAmount()+"  "+b.getPercent()+"  "+b.getCurrency()+"  "+b.getDateIssue()+"  "+b.getDateReturn());
       // }
    }
}
  //  private static void CallProcedureForInsertToPersonBook() throws SQLException {
  //      Scanner input = new Scanner(System.in);
  //      System.out.println("\nInput Surname for Person: ");
  //      String surname = input.next();
  //      System.out.println("Input NameBook for Book: ");
  //      String book = input.next();
//
  //      CallableStatement callableStatement;
  //      callableStatement = connection.prepareCall("{call InsertPersonBook(?, ?)}");
  //      callableStatement.setString("SurmanePersonIn", surname);
  //      callableStatement.setString("BookNameIN", book);
  //      ResultSet rs = callableStatement.executeQuery();
//
  //      while (rs.next()) {
  //          String msg = rs.getString(1);
  //          // Simply Print the results
  //          System.out.format("\nResult: " + msg);
  //      }
  //  }