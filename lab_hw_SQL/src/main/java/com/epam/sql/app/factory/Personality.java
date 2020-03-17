package com.epam.sql.app.factory;

import com.epam.sql.banksystem.entity.Client;

public interface Personality {
    Client getPersonalDateOfClient(int IdClient);
}
