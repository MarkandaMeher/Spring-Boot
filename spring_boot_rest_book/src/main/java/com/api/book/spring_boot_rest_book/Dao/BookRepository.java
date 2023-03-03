package com.api.book.spring_boot_rest_book.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.spring_boot_rest_book.Entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{

public Book findById(int Id);
    
}
