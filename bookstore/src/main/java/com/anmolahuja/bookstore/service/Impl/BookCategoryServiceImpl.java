package com.anmolahuja.bookstore.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anmolahuja.bookstore.entity.BookCategory;
import com.anmolahuja.bookstore.repository.BookCategoryRepository;
import com.anmolahuja.bookstore.service.BookCategoryService;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public List<BookCategory> getAllCategory() {
		return new ArrayList<BookCategory>(bookCategoryRepository.findAll());
	}

}
