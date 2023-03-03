package com.api.book.spring_boot_rest_book.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.book.spring_boot_rest_book.Dao.BookRepository;
import com.api.book.spring_boot_rest_book.Entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(101,"Java","xyz"));
    //     list.add(new Book(102,"python","abc"));
    //     list.add(new Book(103,"Cpp","sfj"));

    // }

    //get all books
    public List<Book> getAllBook(){
        // return list;
        return (List<Book>) this.bookRepository.findAll();

    }

    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        try{
            // book=list.stream().filter(e->e.getId()==id).findFirst().get();
            book = this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return book;
    }

    //adding book
    public Book addBook(Book book){
        // list.add(book);
        Book res = bookRepository.save(book);
        return res;
    }

    //delete book
    public void deleteBook(int bid){
        // list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    public void updateBook(Book book,int bid){
    //     list = list.stream().map(e->{
    //         if(e.getId()==bid){
    //             e.setTitle(book.getTitle());
    //             e.setAuthor(book.getAuthor());
    //         }
    //         return e;
    // }).collect(Collectors.toList());

        book.setId(bid);
        bookRepository.save(book);
    }

}
