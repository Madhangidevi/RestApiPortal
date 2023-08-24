package com.example.day6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6.model.model;
import com.example.day6.repository.repo;

@Service
public class service {
        
	   @Autowired
	   public repo hrepo;
	   //post the data
	   public String saveHotel(model h)
	   {
		   hrepo.save(h);
		   return "Data is saved to database";
	   }
	   //get the data
	   public List<model> getHotel()
	   {
		   return hrepo.findAll();
	   }
	   //sorting
	   public List<model> sortByAsc(String hotelname)
	   {
		   return hrepo.findAll(Sort.by(hotelname).ascending());
	   }
	   //pagination 
	   public List<model> pagination(int pageNo,int pageSize)
	   {
		   Page<model> cont=hrepo.findAll(PageRequest.of(pageNo, pageSize));
		   return cont.getContent();
	   }
	   //pagination and sorting
	   public List<model> paginationAndSorting(int pageNo,int pageSize,String name)
	   {
		   Page<model> cont1=hrepo.findAll(PageRequest.of(pageNo, pageSize,Sort.by(name)));
		   return cont1.getContent();
	   }
}
