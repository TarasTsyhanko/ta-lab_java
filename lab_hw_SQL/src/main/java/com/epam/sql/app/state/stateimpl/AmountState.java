package com.epam.sql.app.state.stateimpl;

import com.epam.sql.app.scaner.MyConsole;
import com.epam.sql.app.state.Create;
import com.epam.sql.app.state.OperationState;

public class AmountState implements OperationState {
    public AmountState(Create create) {
        log.info("Choose amount your Operation :");
        create.getOperation().setAmount(MyConsole.readInt());
    }
    public void selectCurrency(Create create) {
        log.info("operation is in Consideration of Currency");
        create.setOperationState(new CurrencyState(create));
    }
}
