package com.anmolahuja.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anmolahuja.bookstore.exception.handler.CustomApiSuccessResponse;
import com.anmolahuja.bookstore.service.BookService;

@Configuration
@RestController
@CrossOrigin("http://localhost:4200")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/books")
	public ResponseEntity<CustomApiSuccessResponse> getAllBooks() {
		CustomApiSuccessResponse response = new CustomApiSuccessResponse("getAllBooks", "OK", 200,
				bookService.getAllBooks(), true, false);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/books/{id}")
	public ResponseEntity<CustomApiSuccessResponse> getBookById(@PathVariable Long id)
	{
		CustomApiSuccessResponse response = new CustomApiSuccessResponse("getBookById", "OK", 200,
				bookService.getBookById(id), true, false);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
