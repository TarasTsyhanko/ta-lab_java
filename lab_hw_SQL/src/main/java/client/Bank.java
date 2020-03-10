package client;

import banksystem.entity.Location;

import java.util.Objects;

public class Bank implements Client {
    private int id;
    private String name;
    private Location location;
    private ClientType type = ClientType.BANK;

    public Bank() {
    }

    @Override
    public ClientType getClientType() {
        return type;
    }

    public int getIdClient() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) &&
                Objects.equals(location, bank.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
