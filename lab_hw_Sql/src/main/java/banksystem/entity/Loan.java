package banksystem.entity;

import java.sql.Date;
import java.util.Objects;

public class Loan extends Operation {
    public Loan() {
    }

    public Loan(float IDOperation, float IDBank, float IDClient, int amount, double percent, String currency, Date dateIssue, Date dateReturn) {
        super(IDOperation, IDBank, IDClient, amount, percent, currency, dateIssue, dateReturn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Float.compare(operation.IDBank, IDBank) == 0 &&
                Float.compare(operation.IDClient, IDClient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDBank, IDClient);
    }
}
