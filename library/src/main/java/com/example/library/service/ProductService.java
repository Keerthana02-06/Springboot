package com.example.library.service;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.entity.Product;


public interface ProductService  {
	
	
	public List<Product> findAllBooks();
	
	public List<Product> findBookById(int id);
	
	
	public void deleteBook(int id);
	
	public List<Product> searchBooks(String keyword);

}