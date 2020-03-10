package factory;

import banksystem.entity.Operation;

public interface BankSystem {
    Operation createOperation(Operation operation);
}
