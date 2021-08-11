package com.anmolahuja.bookstore.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.anmolahuja.bookstore.entity.Book;
import com.anmolahuja.bookstore.entity.BookCategory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BooksPaginationDto {

	private List<Book> books;
	
	private long totalElements;
	
	private long totalPages;
	
	private long pageSize;
	
	private long number;
	
}
