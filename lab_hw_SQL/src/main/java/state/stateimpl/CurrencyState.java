package state.stateimpl;

import banksystem.MyConsole;
import client.Current;
import state.Create;
import state.OperationState;

public class CurrencyState implements OperationState {
    public CurrencyState(Create create) {
        log.info( "Choose currency: \n - UAN\n - USD\n - EUR ");
        create.getOperation().setCurrency(Current.valueOf(MyConsole.readString().toUpperCase()));
    }
    public void selectReturnDate(Create create) {
        log.info("operation is in Consideration of Return Date");
        create.setOperationState(new ReturnDateState(create));
    }
}
