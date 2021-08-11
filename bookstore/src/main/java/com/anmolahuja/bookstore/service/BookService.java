package com.anmolahuja.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anmolahuja.bookstore.dto.BooksPaginationDto;
import com.anmolahuja.bookstore.entity.Book;

@Service
public interface BookService {

	public BooksPaginationDto getAllBooks(int page,int size);
	
	public Book getBookById(Long id);
	
	public BooksPaginationDto findBooksByCategoryId(Long id,int page,int size);
	
	public BooksPaginationDto findByNameContaining(String name,int page,int size);
}
