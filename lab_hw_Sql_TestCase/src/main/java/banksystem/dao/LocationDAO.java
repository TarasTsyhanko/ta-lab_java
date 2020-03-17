package banksystem.dao;

import banksystem.entity.Bank;
import banksystem.entity.Location;

import java.util.List;

public interface LocationDAO {
    List<Location> getAllLocations();
    Location getLocationByBank(Bank bank);
    Location getLocation(Location location);
    void insertLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(Location location);
    boolean isLocationFree(int IdLocation);
    public boolean isLocationExists(Location location);
}
