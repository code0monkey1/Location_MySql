package com.chiranjeev.location.service;

import com.chiranjeev.location.entities.Location;

import java.util.List;

public interface LocationServices {

    Location getLocationById(int id);
    void deleteLocation(Location location);
    Location updateLocation(Location location);
    Location saveLocation(Location location);
    List<Location> getAllLocations();
    
}
