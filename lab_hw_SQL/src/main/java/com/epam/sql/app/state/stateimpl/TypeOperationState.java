package com.epam.sql.app.state.stateimpl;

import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.app.enums.OperationType;
import com.epam.sql.app.state.Create;
import com.epam.sql.app.state.OperationState;
import com.epam.sql.banksystem.dao.databasedao.OperationDataBaseDAO;

public class TypeOperationState implements OperationState {
    public TypeOperationState(Create create) {
        log.info("Chose type Operation:\n - LOAN\n - DEPOSIT\n - INVESTMENT");
        create.getOperation().setType(OperationType.valueOf(MyConsole.readString().toUpperCase()));
        if (create.getOperation().getType() == OperationType.LOAN) {
            if (new OperationDataBaseDAO().isClientHasAlreadyLoan(create.getOperation())) {
                log.info("You already have LOAN in this Bank, You can't take another !");
                new TypeOperationState(create);
            }
        }
    }

    public void selectAmount(Create create) {
        log.info("operation is in Consideration of Amount");
        create.setOperationState(new AmountState(create));
    }
}
