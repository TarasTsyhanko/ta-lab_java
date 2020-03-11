package com.epam.sql.app.factory.impl;

import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.app.enums.Current;
import com.epam.sql.app.factory.UpdateOperation;
import com.epam.sql.banksystem.entity.Operation;
import com.epam.sql.banksystem.service.OperationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

/**
 * S - single responsibility principle.
 * O - open/close principle.
 * L - liskov substitution principle.
 * I - interface segregation principle.
 * D - dependency  inversion principle.
 */
public class UpdateOperationImpl implements UpdateOperation {
    private static Logger log = LogManager.getLogger(UpdateOperationImpl.class);

    @Override
    public Operation updateOperation(Operation operation) {
        String key;
        do {
            log.info("    -----------------------------");
            log.info("    |  1 - Change Amount        |");
            log.info("    |  2 - Change Currency      |");
            log.info("    |  3 - Change Return Date   |");
            log.info("    |    Q - save changes       |");
            log.info("    | Please, select menu point |");
            log.info("    -----------------------------");
            key = MyConsole.readString().toUpperCase();
            try {
                switch (key) {
                    case "1":
                        log.info("Input amount :");
                        operation.setAmount(MyConsole.readInt());
                        break;
                    case "2":
                        log.info("Input Currency : UAN, USD, EUR");
                        operation.setCurrency(Current.valueOf(MyConsole.readString().toUpperCase()));
                        break;
                    case "3":
                        log.info("Input Return Date : <YYYY-MM-DD>");
                        operation.setDateReturn(Date.valueOf(MyConsole.readString()));
                        break;
                }
            } catch (Exception ignored) {
            }
        } while (!key.equals("Q"));
        new OperationService().updateOperation(operation);
        return operation;
    }
}
