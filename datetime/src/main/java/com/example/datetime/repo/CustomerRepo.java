package com.example.datetime.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.datetime.enitity.Customerdetails;

public interface CustomerRepo extends JpaRepository<Customerdetails, String> {
	
	
	@Query(value="select * from customer where date=?1",nativeQuery = true)
	List<Customerdetails> findByDateLike(String date);
   
	
	List<Customerdetails> findByIdLike(String str);
	
	
}
