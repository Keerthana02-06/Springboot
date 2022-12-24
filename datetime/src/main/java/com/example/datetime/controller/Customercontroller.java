package com.example.datetime.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.datetime.enitity.Customerdetails;
import com.example.datetime.repo.CustomerRepo;

@Controller
public class Customercontroller {
	@Autowired 
	CustomerRepo repo;
	
	
	@RequestMapping("/Checkin")
	@ResponseBody
    public ResponseEntity<List<Customerdetails>> home(@RequestParam String name){
		Customerdetails customer=new Customerdetails();
		customer.setLogType("in");
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		customer.setDate(date.toString());
		customer.setTime(time.toString());
		String id=name+time.toString();
		customer.setId(id);
		customer.setName(name);
		repo.save(customer);
    	return new ResponseEntity<List<Customerdetails>>(repo.findByIdLike("%"+id+"%"),HttpStatus.OK) ;
    }
	

	@RequestMapping("/Checkout")
	@ResponseBody
    public ResponseEntity<List<Customerdetails>> home1(@RequestParam String name){
		Customerdetails customer=new Customerdetails();
		customer.setLogType("out");
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		customer.setDate(date.toString());
		customer.setTime(time.toString());
		String id=name+time.toString();
		customer.setId(id);
		customer.setName(name);
		repo.save(customer);
		
		
	
    	return new ResponseEntity<List<Customerdetails>>(repo.findByIdLike("%"+id+"%"),HttpStatus.OK) ;
    }
	
	@RequestMapping("/getAllLog")
	@ResponseBody
    public List<Customerdetails> home2(){
		return repo.findAll();
    }
	
	@RequestMapping("/getDate")
	@ResponseBody
     public List<Customerdetails> home3(@RequestParam String date){
		List<Customerdetails> cus=repo.findByDateLike(date);
		return cus;
}
	
	
}
