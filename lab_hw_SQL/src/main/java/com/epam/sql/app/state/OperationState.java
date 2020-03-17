package com.epam.sql.app.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** S - single responsibility principle.
 *  O - open/close principle.
 *  L - liskov substitution principle.
 *  I - interface segregation principle.
 *  D - dependency  inversion principle.
 */

public interface OperationState {
    Logger log = LogManager.getLogger(OperationState.class);

    default void selectTypeOperation(Create create) {
        log.info("You can't change type Operation");
    }

    default void selectAmount(Create create) {
        log.info("You can't change Amount");
    }

    default void selectCurrency(Create create) {
        log.info("You can't change Currency");
    }

    default void selectReturnDate(Create create) {
        log.info("You can't change Return Date");
    }
    default void registerOperation(Create create) {
        log.info("You can't register operation in this state");
    }
    default void refuseOperation(Create create) {
        log.info("You can't refuse Operation");
    }

    default void saveOperation(Create create) {
        log.info("You can't save Operation");
    }
}
