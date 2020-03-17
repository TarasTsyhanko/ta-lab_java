package com.epam.sql.app.factory;

import com.epam.sql.banksystem.entity.Operation;

public interface BankSystem {
    Operation createOperation(Operation operation);
}
