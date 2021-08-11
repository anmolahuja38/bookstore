package com.anmolahuja.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anmolahuja.bookstore.exception.handler.CustomApiSuccessResponse;
import com.anmolahuja.bookstore.service.BookCategoryService;

@Configuration
@RestController
@CrossOrigin("http://localhost:4200")
public class BookCategoryController {

	@Autowired
	private BookCategoryService bookCategoryService;

	@GetMapping(path = "/category")
	@ResponseBody
	public ResponseEntity<CustomApiSuccessResponse> getAllCategory() {
		CustomApiSuccessResponse response = new CustomApiSuccessResponse("getAllCategory", "OK", 200,
				bookCategoryService.getAllCategory(), true, false);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
