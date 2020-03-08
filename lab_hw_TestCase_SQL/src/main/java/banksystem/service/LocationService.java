package banksystem.service;

import banksystem.config.exception.InfoException;
import banksystem.dao.BankDAO;
import banksystem.dao.LocationDAO;
import banksystem.dao.databasedao.BankDataBaseDAO;
import banksystem.dao.databasedao.LocationDataBaseDAO;
import banksystem.entity.Bank;
import banksystem.entity.Location;

import java.util.List;

public class LocationService {
    private LocationDAO locationDAO;
    private BankDAO bankDAO;

    public LocationService() {
        locationDAO = new LocationDataBaseDAO();
        bankDAO = new BankDataBaseDAO();
    }

    public List<Location> getAllLocation() {
        return locationDAO.getAllLocations();
    }
    public Location getLocation(Location location) throws InfoException {
        if (locationDAO.isLocationExists(location)) {
            return locationDAO.getLocation(location);
        }else {
            throw new InfoException("This Location absent");
        }
    }
    public Location getLocationByBank(Bank bank) throws InfoException {
        if (bankDAO.isBankExists(bank.getName())){
            return locationDAO.getLocationByBank(bank);
        }else {
            throw new InfoException("This bank absent");
        }
    }

    public void insertLocation(Location location) throws InfoException {
        if (!locationDAO.isLocationExists(location)) {
            locationDAO.insertLocation(location);
        }else {
            throw new InfoException("This Location already exists");
        }
    }

    public void updateLocation(Location location) throws InfoException {
        if (!locationDAO.isLocationExists(location)) {
            locationDAO.updateLocation(location);
        }else {
            throw new InfoException("This Location already exists");
        }
    }

    public void deleteLocation(Location location) throws InfoException {
        if (locationDAO.isLocationExists(location)) {
            if (!bankDAO.getBankByLocation(location).equals(new Bank()))
                new BankService().deleteBank(bankDAO.getBankByLocation(location));
            locationDAO.deleteLocation(location);
        }
    }
}
