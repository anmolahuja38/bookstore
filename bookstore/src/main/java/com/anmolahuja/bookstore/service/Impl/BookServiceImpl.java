package com.anmolahuja.bookstore.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anmolahuja.bookstore.entity.Book;
import com.anmolahuja.bookstore.repository.BookRepository;
import com.anmolahuja.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return new ArrayList(bookRepository.findAll());
	}

	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	}

	public List<Book> findBooksByCategoryId(Long id) {
		return new ArrayList<Book>(bookRepository.findBooksByCategoryId(id));
	}

	public List<Book> findByNameContaining(String name) {
		return new ArrayList<Book>(bookRepository.findByNameContaining(name));
	}

}
