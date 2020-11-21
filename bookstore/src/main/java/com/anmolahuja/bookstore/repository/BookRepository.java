package com.anmolahuja.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anmolahuja.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}