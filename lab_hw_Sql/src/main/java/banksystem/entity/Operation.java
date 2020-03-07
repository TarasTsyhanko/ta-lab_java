package banksystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.Objects;


public abstract class Operation {
    @JsonIgnore
    protected float IDOperation;
    @JsonIgnore
    protected float IDBank;
    @JsonIgnore
    protected float IDClient;
    private int amount;
    private double percent;
    private String currency;
    private Date dateIssue;
    private Date dateReturn;

    public Operation() {
    }

    public Operation(float IDOperation, float IDBank, float IDClient, int amount, double percent, String currency, Date dateIssue, Date dateReturn) {
        this.IDOperation = IDOperation;
        this.IDBank = IDBank;
        this.IDClient = IDClient;
        this.amount = amount;
        this.percent = percent;
        this.currency = currency;
        this.dateIssue = dateIssue;
        this.dateReturn = dateReturn;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getIDOperation() {
        return IDOperation;
    }

    public void setIDOperation(float IDOperation) {
        this.IDOperation = IDOperation;
    }

    public float getIDBank() {
        return IDBank;
    }

    public void setIDBank(float IDBank) {
        this.IDBank = IDBank;
    }

    public float getIDClient() {
        return IDClient;
    }

    public void setIDClient(float IDClient) {
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
                ", IDBank=" + IDBank +
                ", IDClient=" + IDClient +
                ", amount=" + amount +
                ", percent=" + percent +
                ", dateIssue=" + dateIssue +
                ", dateReturn=" + dateReturn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Float.compare(operation.IDBank, IDBank) == 0 &&
                Float.compare(operation.IDClient, IDClient) == 0 &&
                amount == operation.amount &&
                Double.compare(operation.percent, percent) == 0 &&
                Objects.equals(currency, operation.currency) &&
                Objects.equals(dateIssue, operation.dateIssue) &&
                Objects.equals(dateReturn, operation.dateReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDBank, IDClient, amount, percent, currency, dateIssue, dateReturn);
    }
}
