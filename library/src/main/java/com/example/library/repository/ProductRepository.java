package com.example.library.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.library.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{

	
   List<Product> findBygenreLike(String genre);
	
	
           
	}
	