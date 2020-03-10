package state.stateimpl;

import banksystem.MyConsole;
import banksystem.dao.databasedao.OperationDataBaseDAO;
import client.OperationType;
import state.Create;
import state.OperationState;

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
