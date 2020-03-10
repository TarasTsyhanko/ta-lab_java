package state;

import banksystem.entity.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import state.stateimpl.TypeOperationState;

public class Create {
    private static final Logger LOG = LogManager.getLogger(Create.class);
    private OperationState operationState;
    private Operation operation;

    public Create(Operation operation) {
        this.operation = operation;
        operationState = new TypeOperationState(this);
    }

    public void setOperationState(OperationState operationState) {
        this.operationState = operationState;
    }

    public Operation getOperation() {
        return operation;
    }

    public void selectTypeOperation() {
        operationState.selectTypeOperation(this);
    }

    public void selectAmount() {
        operationState.selectAmount(this);
    }

    public void registerOperation() {
        operationState.registerOperation(this);
    }

    public void selectCurrency() {
        operationState.selectCurrency(this);
    }

    public void selectReturnDate() {
        operationState.selectReturnDate(this);
    }

    public void refuseOperation() {
        operationState.refuseOperation(this);
    }

    public void saveOperation() {
        operationState.saveOperation(this);
    }
}
