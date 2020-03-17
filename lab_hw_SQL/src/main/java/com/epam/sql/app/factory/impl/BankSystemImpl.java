package com.epam.sql.app.factory.impl;

import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.app.factory.BankSystem;
import com.epam.sql.banksystem.entity.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.sql.app.state.Create;


/** S - single responsibility principle.
 *  O - open/close principle.
 *  L - liskov substitution principle.
 *  I - interface segregation principle.
 *  D - dependency  inversion principle.
 */

public class BankSystemImpl implements BankSystem {
    private static Logger log = LogManager.getLogger(BankSystemImpl.class);
    @Override
    public Operation createOperation(Operation operation) {
        Create create = new Create(operation);
        String key;
        do {
            log.info("   ------------------------------");
            log.info("   |     1 - Choose amount      |");
            log.info("   |     2 - Choose currency    |");
            log.info("   |     3 - Choose Return Date |" );
            log.info("   |     4 - Register Operation |");
            log.info("   |     5 - Save Operation     |");
            log.info("   |     Q - exit               |");
            log.info("   ------------------------------");
            log.info("      Please, select menu point.");
            key = MyConsole.readString().toUpperCase();
            try {
                switch (key) {
                    case "1":
                        create.selectAmount();
                        break;
                    case "2":
                        create.selectCurrency();
                        break;
                    case "3":
                        create.selectReturnDate();
                        break;
                    case "4":
                        create.registerOperation();
                        break;
                    case "5":
                        create.saveOperation();
                        break;
                }
            } catch (Exception ignored) {
            }
        } while (!key.equals("Q"));
        return create.getOperation();
    }
}
