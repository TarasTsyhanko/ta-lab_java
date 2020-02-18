package serialization.model;

import java.io.Serializable;
import java.util.Objects;
public class Droid implements Serializable {
    private String name;
    private transient Blaster blaster;
    private Type type;
    private int creationYear;

    public Droid(String name, Blaster blaster, Type type, int creationYear) {
        this.name = name;
        this.blaster = blaster;
        this.type = type;
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blaster getBlaster() {
        return blaster;
    }

    public void setBlaster(Blaster blaster) {
        this.blaster = blaster;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
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