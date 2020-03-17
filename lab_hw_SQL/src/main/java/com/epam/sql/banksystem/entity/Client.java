package com.epam.sql.banksystem.entity;

import com.epam.sql.app.enums.ClientType;

public interface Client {
    int getIdClient();
    ClientType getClientType();
}
