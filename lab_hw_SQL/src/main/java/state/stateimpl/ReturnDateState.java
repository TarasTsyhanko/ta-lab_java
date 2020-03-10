package state.stateimpl;

import banksystem.MyConsole;
import state.Create;
import state.OperationState;

import java.sql.Date;

public class ReturnDateState implements OperationState {
    public ReturnDateState(Create create) {
        log.info("Choose return date your operation\n In format YYYY-MM-DD");
        create.getOperation().setDateReturn(Date.valueOf(MyConsole.readString()));
    }
    public void registerOperation(Create create) {
        log.info("You operation is register  state");
        create.setOperationState(new RegisterOperationState(create));
    }
}
