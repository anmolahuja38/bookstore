package com.anmolahuja.bookstore.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.anmolahuja.bookstore.dto.BooksPaginationDto;
import com.anmolahuja.bookstore.entity.Book;
import com.anmolahuja.bookstore.repository.BookRepository;
import com.anmolahuja.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public BooksPaginationDto getAllBooks(int page,int size) {
		//return new ArrayList(bookRepository.findAll());
		Page<Book> bookData=bookRepository.findAll(PageRequest.of(page, size));
		BooksPaginationDto booksPaginationDto=new BooksPaginationDto();
		booksPaginationDto.setBooks(new ArrayList<Book>(bookData.getContent()));
		booksPaginationDto.setTotalElements(bookData.getTotalElements());
		booksPaginationDto.setTotalPages(bookData.getTotalPages());
		booksPaginationDto.setNumber(page);
		booksPaginationDto.setPageSize(size);
		return booksPaginationDto;
	}

	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	}

	public BooksPaginationDto findBooksByCategoryId(Long id,int page,int size) {
		Page<Book> bookData=(Page<Book>) bookRepository.findBooksByCategoryId(id, PageRequest.of(page, size));
		BooksPaginationDto booksPaginationDto=new BooksPaginationDto();
		booksPaginationDto.setBooks(new ArrayList<Book>(bookData.getContent()));
		booksPaginationDto.setTotalElements(bookData.getTotalElements());
		booksPaginationDto.setTotalPages(bookData.getTotalPages());
		booksPaginationDto.setPageSize(size);
		booksPaginationDto.setNumber(page);
		return booksPaginationDto;
	}

	public BooksPaginationDto findByNameContaining(String name,int page,int size) {
		Page<Book> bookData=(Page<Book>) bookRepository.findByNameContaining(name, PageRequest.of(page, size));
		BooksPaginationDto booksPaginationDto=new BooksPaginationDto();
		booksPaginationDto.setBooks(new ArrayList<Book>(bookData.getContent()));
		booksPaginationDto.setTotalElements(bookData.getTotalElements());
		booksPaginationDto.setTotalPages(bookData.getTotalPages());
		booksPaginationDto.setPageSize(size);
		booksPaginationDto.setNumber(page);
		return booksPaginationDto;
	}

}
