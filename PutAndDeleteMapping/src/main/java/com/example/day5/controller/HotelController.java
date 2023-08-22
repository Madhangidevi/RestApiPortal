package com.example.day5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5.model.HotelModel;
import com.example.day5.service.HotelService;

@RestController
public class HotelController {

	    @Autowired
	    public HotelService hserv;
	    //post mapping
	    @PostMapping("/posthotel")
	    public String postHotel(@RequestBody HotelModel hr)
	    {
	    	hserv.saveHotel(hr);
	    	return "Data saved";
	    }
	    //get mapping
	    @GetMapping("/gethotel")
	    public List<HotelModel>getHotelInfo()
	    {
	    	return hserv.getHotel();
	    }
	    //put mapping
	    @PutMapping("/updateHotel")
	    public HotelModel updateHotelInfo(@RequestBody HotelModel ha)
	    {
	    	return hserv.updateHotel(ha);
	    }
	    //delete using path variable
	    @DeleteMapping("/delete/{id}")
	    public String removeHotel(@PathVariable("id") int hid)
	    {
	    	hserv.deleteHotel(hid);
	    	return "Hotel with Id "+hid+" is deleted";	 
	    }
	    @DeleteMapping("/byReqPam")
	    public String removeByRequestPam(@RequestParam("id") int id)
	    {
	    	hserv.deleteHotel(id);
	    	return "Hotel with Id "+id+" is deleted";	 
	    }
	    @DeleteMapping("/deleteHotelif/{id}")
	     public ResponseEntity<String> deleteHotelInfo(@PathVariable int id)
	     {
	    	 boolean deleted=hserv.deleteHotelif(id);
	    	 if(deleted)
	    	 {
	    		 return ResponseEntity.ok("Hotel with id "+id+" deleted successfully");
	    	 }
	    	 else
	    	 {
	    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID"+id+" not found");
	    	 }
	     }
	    @PutMapping("/putHotelif/{id}")
		public ResponseEntity<String> updateHotelInfor(@PathVariable int id,@RequestBody HotelModel ha)
		{
			boolean updated = hserv.updateHotelif(id, ha);
			if(updated)
			{
				return ResponseEntity.ok("Hotel with Id" + id+" updated successfully");//ok means success//
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with Id " + id + " not found and not updated");
			}
			
		}
	    @GetMapping("/users/{userId}")
		public ResponseEntity<?> getUserById (@PathVariable int userid)
		{
		Optional<HotelModel> hotel = hserv.getUserId(userid);
		
		if(hotel!=null)
		{
			return ResponseEntity.ok(hotel);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not avaliable with Id");
		}
}
