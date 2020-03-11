package com.epam.sql.app.state.stateimpl;

import com.epam.sql.app.enums.OperationType;
import com.epam.sql.app.state.Create;
import com.epam.sql.app.state.OperationState;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public class RegisterOperationState implements OperationState {
    public RegisterOperationState(Create create) {
        create.getOperation().setDateIssue(Date.valueOf(LocalDate.now()));
        double percent;
        if(create.getOperation().getType()== OperationType.LOAN) {
            percent = new Random().nextInt(195+111);
        }else percent = Math.random()*(96+11)/10;
        percent = percent/10;
        create.getOperation().setPercent(percent);
        log.info(create.getOperation().getBankName()+" can propose you PERCENT: "+percent);
    }
    public void saveOperation(Create create) {
        log.info("Operation is saving...");
        create.setOperationState(new SaveOperationState(create));
    }
}
