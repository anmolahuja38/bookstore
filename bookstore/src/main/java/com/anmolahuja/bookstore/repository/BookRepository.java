package com.anmolahuja.bookstore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anmolahuja.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {

	public Page<Book> findBooksByCategoryId(Long id,Pageable pageable);

	public Page<Book> findByNameContaining(String name,Pageable pageable);
}
