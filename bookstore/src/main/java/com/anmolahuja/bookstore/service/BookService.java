package com.anmolahuja.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anmolahuja.bookstore.entity.Book;

@Service
public interface BookService {

	public List<Book> getAllBooks();
	
	public Book getBookById(Long id);
}
