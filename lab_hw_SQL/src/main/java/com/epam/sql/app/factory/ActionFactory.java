package com.epam.sql.app.factory;

import com.epam.sql.app.enums.Action;
import com.epam.sql.banksystem.entity.ClientAccount;

public interface ActionFactory {
     ClientAccount openAccount(Action action) ;
}
