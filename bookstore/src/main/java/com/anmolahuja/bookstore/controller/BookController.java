package com.anmolahuja.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	public ResponseEntity<CustomApiSuccessResponse> getAllBooks(@RequestParam(required=false,defaultValue="0") Integer page,@RequestParam(required=false,defaultValue="5") Integer size) {
		CustomApiSuccessResponse response = new CustomApiSuccessResponse("getAllBooks", "OK", 200,
				bookService.getAllBooks(page,size), true, false);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/books/{id}")
	@ResponseBody
	public ResponseEntity<CustomApiSuccessResponse> getBookById(@PathVariable Long id) {
		CustomApiSuccessResponse response = new CustomApiSuccessResponse("getBookById", "OK", 200,
				bookService.getBookById(id), true, false);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/books/category")
	@ResponseBody
	public ResponseEntity<CustomApiSuccessResponse> findBooksByCategoryId(@RequestParam("id") Long id,@RequestParam(required=false,defaultValue="0") Integer page,@RequestParam(required=false,defaultValue="5") Integer size) {
		CustomApiSuccessResponse response = new CustomApiSuccessResponse("findByCategoryId", "OK", 200,
				bookService.findBooksByCategoryId(id,page,size), true, false);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/books/search")
	@ResponseBody
	public ResponseEntity<CustomApiSuccessResponse> findByNameContaining(@RequestParam("name") String name,@RequestParam(required=false,defaultValue="0") Integer page,@RequestParam(required=false,defaultValue="5") Integer size) {
		CustomApiSuccessResponse response = new CustomApiSuccessResponse("findByNameContaining", "OK", 200,
				bookService.findByNameContaining(name,page,size), true, false);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
