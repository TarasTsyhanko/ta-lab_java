package banksystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Bank {
    @JsonIgnore
    private float id;
    private String name;
    @JsonIgnore
    private float IDLocation;

    public Bank() {
    }

    public Bank( String name, float IDLocation) {
        this.name = name;
        this.IDLocation = IDLocation;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getIDLocation() {
        return IDLocation;
    }

    public void setIDLocation(float IDLocation) {
        this.IDLocation = IDLocation;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locationID=" + IDLocation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return  IDLocation == bank.IDLocation &&
                Objects.equals(name, bank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, IDLocation);
    }
}
