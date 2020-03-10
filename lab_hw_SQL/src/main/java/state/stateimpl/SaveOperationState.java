package state.stateimpl;

import banksystem.config.exception.InfoException;
import banksystem.entity.Operation;
import banksystem.service.OperationService;
import state.Create;
import state.OperationState;

public class SaveOperationState implements OperationState {
    public SaveOperationState(Create create) {
        OperationService operationService = new OperationService();
        try {
             Operation operation = operationService.insertOperation(create.getOperation());
            log.info("Your operation successfully saved");
            log.info("Thank You for using our bank");
        } catch (InfoException e) {
            log.error("Your operation not save");
        }
    }
}
