package state.stateimpl;

import banksystem.MyConsole;
import state.Create;
import state.OperationState;

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
