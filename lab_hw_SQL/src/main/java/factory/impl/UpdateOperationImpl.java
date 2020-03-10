package factory.impl;

import banksystem.MyConsole;
import banksystem.entity.Operation;
import banksystem.service.OperationService;
import client.Current;
import factory.UpdateOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

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
