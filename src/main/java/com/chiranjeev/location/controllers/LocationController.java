package com.chiranjeev.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chiranjeev.location.entities.Location;
import com.chiranjeev.location.service.LocationServices;

@Controller
public class LocationController {


	@Autowired
	LocationServices service;

	@RequestMapping("/showCreate")
	public String showCreate(){
		return "createLocation";
	}
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap ) {
		service.saveLocation(location);
		String msg="Location saved with id: "+location.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}


	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		Location loc=service.getLocationById(id);
		service.deleteLocation(loc);

		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);

		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id")int id,ModelMap modelMap) {
		Location location=service.getLocationById(id);
        modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updaetLoc(@ModelAttribute("location") Location location,ModelMap modelMap ) {
		service.updateLocation(location);
		List locations= service.getAllLocations();
		modelMap.addAttribute("location",locations);
		
		return "displayLocations";
	}

}