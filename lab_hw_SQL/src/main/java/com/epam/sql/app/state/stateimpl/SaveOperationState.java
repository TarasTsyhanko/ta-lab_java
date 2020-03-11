package com.epam.sql.app.state.stateimpl;

import com.epam.sql.app.state.Create;
import com.epam.sql.app.state.OperationState;
import com.epam.sql.banksystem.config.exception.InfoException;
import com.epam.sql.banksystem.entity.Operation;
import com.epam.sql.banksystem.service.OperationService;

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
