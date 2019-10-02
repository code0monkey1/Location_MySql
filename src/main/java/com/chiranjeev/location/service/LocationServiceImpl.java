package com.chiranjeev.location.service;

import com.chiranjeev.location.entities.Location;
import com.chiranjeev.location.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocationServiceImpl implements LocationServices {
    @Autowired
    private LocationRepository repository;
    
    @Override
    public Location getLocationById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteLocation(Location location) {
        repository.delete(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public Location saveLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}
