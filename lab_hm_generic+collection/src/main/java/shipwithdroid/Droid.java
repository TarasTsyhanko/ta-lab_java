package shipwithdroid;

import java.util.Objects;

public class Droid implements Comparable<Droid> {
    private String name;
    private String type;

    public Droid(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Droid{name='" + this.name + '\'' + ", type='" + this.type + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Droid droid = (Droid)o;
            return this.name.equals(droid.name) && this.type.equals(droid.type);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.type});
    }

    public int compareTo(Droid o) {
        return this.name.compareTo(o.name);
    }
}