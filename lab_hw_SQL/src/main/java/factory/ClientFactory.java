package factory;

import banksystem.config.exception.InfoException;
import client.Client;
import client.ClientType;

public interface ClientFactory {
    Client createClient(ClientType type) throws InfoException;
}
