package factory;

import banksystem.entity.ClientAccount;
import client.Action;

public interface ActionFactory {
     ClientAccount openAccount(Action action) ;
}
