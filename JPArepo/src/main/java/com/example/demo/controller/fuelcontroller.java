package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.petrolbunk;
import com.example.demo.service.fuelservice;

@RestController
public class fuelcontroller {
  
	@Autowired
	fuelservice fser;
	@PostMapping("/saveFuel")
	public petrolbunk saveFuelStationDe(@RequestBody petrolbunk pb)
	{
		return fser.saveDetails(pb);
	}
	@GetMapping("/getFuel")
	public List<petrolbunk> getFuelStationDe()
	{
		return fser.getDetails();
	}
	
}
