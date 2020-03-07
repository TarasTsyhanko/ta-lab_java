package banksystem.entity;

import java.sql.Date;

public class Investment extends Operation {
    public Investment() {
    }

    public Investment(float IDOperation, float IDBank, float IDClient, int amount, double percent, String currency, Date dateIssue, Date dateReturn) {
        super(IDOperation, IDBank, IDClient, amount, percent, currency, dateIssue, dateReturn);
    }
}
