package com.example.day6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.day6.model.model;
import com.example.day6.service.service;
@RestController
public class controller {

	    @Autowired
	    public service hserv;
	    //post the data
	    @PostMapping("/posthotel")
	    public String postHotel(@RequestBody model hr)
	    {
	    	hserv.saveHotel(hr);
	    	return "Data saved";
	    }
	    //get the data
	    @GetMapping("/gethotel")
	    public List<model> getHotelInfo()
	    {
	    	return hserv.getHotel();
	    }
	    //sort by ascending
	    @GetMapping("/sortAsc/{name}")
	    public List<model>sortasc(@PathVariable("name")String hotelname)
	    {
	    	return hserv.sortByAsc(hotelname);
	    }
	    @GetMapping("/paginationsort/{num}/{size}/{name}")
  	  public List<model> paginationsorting(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("name") String name)
  	  {
  		  return hserv.paginationAndSorting(num, size, name);
  	  }
}
