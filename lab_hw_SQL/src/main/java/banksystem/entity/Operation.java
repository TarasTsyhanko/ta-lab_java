package banksystem.entity;

import client.Current;
import client.OperationType;

import java.sql.Date;
import java.util.Objects;


public class Operation {
    private int IDOperation;
    private String bankName;
    private int IDClient;
    private int amount;
    private double percent;
    private Current currency;
    private Date dateIssue;
    private Date dateReturn;
    private OperationType type;

    public Operation() {
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Current getCurrency() {
        return currency;
    }

    public void setCurrency(Current currency) {
        this.currency = currency;
    }

    public int getIDOperation() {
        return IDOperation;
    }

    public void setIDOperation(int IDOperation) {
        this.IDOperation = IDOperation;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "IDOperation=" + IDOperation +
                ", bankName='" + bankName + '\'' +
                ", IDClient=" + IDClient +
                ", amount=" + amount +
                ", percent=" + percent +
                ", currency='" + currency + '\'' +
                ", dateIssue=" + dateIssue +
                ", dateReturn=" + dateReturn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return IDClient == operation.IDClient &&
                amount == operation.amount &&
                Double.compare(operation.percent, percent) == 0 &&
                Objects.equals(bankName, operation.bankName) &&
                Objects.equals(currency, operation.currency) &&
                Objects.equals(dateIssue, operation.dateIssue) &&
                Objects.equals(dateReturn, operation.dateReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, IDClient, amount, percent, currency, dateIssue, dateReturn);
    }
}
