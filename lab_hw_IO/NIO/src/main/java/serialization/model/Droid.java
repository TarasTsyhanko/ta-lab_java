package serialization.model;

import java.io.Serializable;
import java.util.Objects;
public class Droid implements Serializable {
    private String name;
    private transient  Blaster blaster;
    private Type type;
    private int creationYear;
    private static int currentYear;                 //  static field not serializable
    private static final long serialVersionUID =7L;

    public Droid(String name, Blaster blaster, Type type, int creationYear,int currentYear) {
        this.name = name;
        this.blaster = blaster;
        this.type = type;
        this.creationYear = creationYear;
        this.currentYear = currentYear;
    }


    public static int getCurrentYear() {
        return currentYear;
    }

    public String getName() {
        return name;
    }

    public Blaster getBlaster() {
        return blaster;
    }

    public Type getType() {
        return type;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String toString() {
        return "Droid{name='" + name + '\'' + ", type='" +type + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Droid droid = (Droid)o;
            return name.equals(droid.name) && type.equals(droid.type);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(name,type);
    }

}