package com.epam.sql.app.factory;

import com.epam.sql.banksystem.config.exception.SQLInfoException;
import com.epam.sql.banksystem.entity.Client;
import com.epam.sql.app.enums.ClientType;

public interface ClientFactory {
    Client createClient(ClientType type) throws SQLInfoException;
}
